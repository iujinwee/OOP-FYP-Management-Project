package Database;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Projects.Project;
import Requests.Request;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.Student;
import Users.Supervisor;
import Users.UserDetails.User;
import Login.Account;

public class FileHandler {
    private final static String dataPath = "\\App\\data\\";
    
    public static ArrayList<Object> readExcelFile(String filePath, Object item) {
        
        // Path Name 
        String pathname = System.getProperty("user.dir").concat(dataPath);
        String finalPath = pathname.concat(filePath);
        ArrayList<Object> resultList = new ArrayList<>();
        Map<String, Integer> columnMap = new HashMap<>();

        try {
            FileInputStream inputStream = new FileInputStream(new File(finalPath));
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);   // Create Workbook
            XSSFSheet sheet = wb.getSheetAt(0);  // Change to Worksheet
            
            // read header row to create column map
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                columnMap.put(cell.getStringCellValue(), cell.getColumnIndex());
            }
            
            // read data rows
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    // skip header row
                    continue;
                }

                switch (item.getClass().getSimpleName()) {
                    case "Account":
                        String userID = getStringCellValue(row.getCell(columnMap.get("ID")));

                        Account tempAccount = (Account) item
                            .getClass()
                            .getDeclaredConstructor(String.class)
                            .newInstance(userID);
                        resultList.add(tempAccount);

                        break;
                        
                    case "Student":
                    case "Supervisor":
                    case "FYP_Coordinator":
                        String id  = getStringCellValue(row.getCell(columnMap.get("ID")));
                        String name  = getStringCellValue(row.getCell(columnMap.get("Name")));
                        String email  = getStringCellValue(row.getCell(columnMap.get("Email")));

                        User tempUser = (User) item
                            .getClass()
                            .getDeclaredConstructor(String.class, String.class, String.class)
                            .newInstance(id, name, email);
                        resultList.add(tempUser);

                        break;

                    case "Project":

                        // Load Project Information
                        int projId  = getNumericCellValue(row.getCell(columnMap.get("ID")));
                        String supId  = getStringCellValue(row.getCell(columnMap.get("SupervisorID")));
                        String stuId  = getStringCellValue(row.getCell(columnMap.get("StudentID")));
                        String title  = getStringCellValue(row.getCell(columnMap.get("Title")));
                        String rejectString  = getStringCellValue(row.getCell(columnMap.get("Rejected")));
                        StudentDB stu = new StudentDB();
                        SupervisorDB sup = new SupervisorDB();
                        String[] rejectList = rejectString.split("|");
                        ArrayList<String> rejectStrList = new ArrayList<>(Arrays.asList(rejectList));

                        Project tempProject = (Project) item
                            .getClass()
                            .getDeclaredConstructor(int.class, String.class, Student.class, Supervisor.class, ArrayList.class)
                            .newInstance(projId, title, stu.findInstance(stuId), sup.findInstance(supId), rejectStrList);

                        resultList.add(tempProject);

                        break;

                    case "Request": 
                        String reqId = getStringCellValue(row.getCell(columnMap.get("ID")));
                        String fromUser = getStringCellValue(row.getCell(columnMap.get("fromUser")));
                        String toUser = getStringCellValue(row.getCell(columnMap.get("toUser")));
                        String type = getStringCellValue(row.getCell(columnMap.get("type")));
                        String status = getStringCellValue(row.getCell(columnMap.get("status")));
                        String projID = getStringCellValue(row.getCell(columnMap.get("projectID")));
                        String newTitle = getStringCellValue(row.getCell(columnMap.get("newTitle")));
                        String newSupervisor = getStringCellValue(row.getCell(columnMap.get("newSupervisor")));

                        Request tempRequest = (Request) item
                            .getClass()
                            .getDeclaredConstructor(int.class, User.class, User.class, RequestStatus.class, RequestType.class, int.class)
                            .newInstance(reqId, fromUser, toUser, type, status, projID);

                        if (newTitle!=""){
                            tempRequest.setNewTitle(newTitle);
                        }

                        if (newSupervisor!=""){
                            tempRequest.setNewSupervisor(newSupervisor);
                        }
                        
                        resultList.add(tempRequest);

                        break;
                        
                    default:
                        break;
                }

            
            }
            
            wb.close();
            inputStream.close();

        }catch(IOException e){
            e.printStackTrace();
            
        } catch (ReflectiveOperationException e){
            e.printStackTrace();
        }
        return resultList;
    }

    public static boolean saveExcelFile(String filePath, ArrayList<Object> result) {
        // Path Name 
        String pathname = System.getProperty("user.dir").concat(dataPath);
        String finalPath = pathname.concat(filePath);
        Map<String, Integer> columnMap = new HashMap<>();
        boolean saveFile = true;

        try {
            FileInputStream inputStream = new FileInputStream(new File(finalPath));
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);   // Create Workbook
            XSSFSheet sheet = wb.getSheetAt(0);  // Change to Worksheet

            // write header row to create column map
            int row_count = 0;
            for (Object item: result) {
                Row row = sheet.getRow(row_count+1);
                if(row == null){
                    row = sheet.createRow(row_count+1);
                }

                int column_count = 0; 
                String className = item.getClass().getSuperclass().getSimpleName();

                switch (className) {
                    case "User":
                        
                        User current_user = (User) result.get(row_count++);
                        row.createCell(column_count++).setCellValue((String) current_user.getUserID());
                        row.createCell(column_count++).setCellValue((String) current_user.getName());
                        row.createCell(column_count++).setCellValue((String) current_user.getEmail());
                        break;

                    case "Project":
                        Project current_proj = (Project) result.get(row_count++);
                        String rejected = String.join("|", current_proj.getRejected());
                        row.createCell(column_count++).setCellValue(current_proj.getProjectID());
                        row.createCell(column_count++).setCellValue(current_proj.getProjectTitle());
                        row.createCell(column_count++).setCellValue(current_proj.getStudentID());
                        row.createCell(column_count++).setCellValue(current_proj.getSupervisorID());
                        row.createCell(column_count++).setCellValue(rejected);
                        break;

                    case "Request": 
                        Request current_req = (Request) result.get(row_count++);

                        String type = "";

                        if(current_req.getRequestType()!=null){
                            type = current_req.getRequestType().toString();
                        }

                        String status = "";
                        if(current_req.getRequestStatus()!=null){
                            status = current_req.getRequestStatus().toString();
                        }

                        row.createCell(column_count++).setCellValue(current_req.getRequestID());
                        row.createCell(column_count++).setCellValue(current_req.getFromUser().getUserID());
                        row.createCell(column_count++).setCellValue(current_req.getToUser().getUserID());
                        row.createCell(column_count++).setCellValue(type);
                        row.createCell(column_count++).setCellValue(status);
                        row.createCell(column_count++).setCellValue(current_req.getProjectID());
                        row.createCell(column_count++).setCellValue(current_req.getNewTitle());
                        row.createCell(column_count++).setCellValue(current_req.getNewSupervisor());
                        break;
                        
                    default:
                        saveFile = false;
                        break;
                }
            }

            FileOutputStream outputStream = new FileOutputStream(finalPath);

            wb.write(outputStream);  
            wb.close();
            outputStream.close();    
            inputStream.close();

        }catch(IOException e){
            e.printStackTrace();
            
        } 
        return saveFile;
    }

    private static String getStringCellValue(Cell cell) {
        String value = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    value = String.valueOf(cell.getNumericCellValue());
                    break;
                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    value = cell.getCellFormula();
                    break;
                default:
                    break;
            }
        }
        return value;
    }
    
    private static int getNumericCellValue(Cell cell) {
        int value = 0;
        if (cell != null) {
            switch (cell.getCellType()) {
                case NUMERIC:
                    value = (int) cell.getNumericCellValue();
                    break;
                case FORMULA:
                    value = (int) cell.getNumericCellValue();
                    break;
                default:
                    break;
            }
        }
        return value;
    }
}

