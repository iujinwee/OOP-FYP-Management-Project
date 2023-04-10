package Database;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Projects.Project;
import Requests.Request;
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
                        String[] rejectList = rejectString.split("|");

                        Project tempProject = (Project) item
                            .getClass()
                            .getDeclaredConstructor(int.class, String.class, Student.class, Supervisor.class, String[].class)
                            .newInstance(projId, title, getStudent(stuId), getSupervisor(supId) , rejectList);

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

                        Request tempRequest = (Request) item.getClass().getDeclaredConstructor().newInstance(reqId, fromUser, toUser, type, status, projID);
                        // if (newTitle!=""){
                        //     tempRequest.addTitle(newTitle);
                        // }else{
                        //     tempRequest.addSupervisor(newSupervisor);
                        // }
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

                int column_count = 0;

                switch (item.getClass().getSimpleName()) {
                    case "Student":
                    case "Supervisor":
                    case "FYP_Coordinator":
                        
                        User current_user = (User) result.get(row_count++);
                        row.getCell(column_count++).setCellValue((String) current_user.getUserID());
                        row.getCell(column_count++).setCellValue((String) current_user.getName());
                        row.getCell(column_count++).setCellValue((String) current_user.getEmail());
                        break;

                    case "Project":
                        Project current_proj = (Project) result.get(row.getRowNum());
                        row.createCell(row.getRowNum()).setCellValue(current_proj.getProjectId());
                        row.createCell(row.getRowNum()).setCellValue(current_proj.getSupervisorId());
                        row.createCell(row.getRowNum()).setCellValue(current_proj.getStudentId());
                        row.createCell(row.getRowNum()).setCellValue(current_proj.getProjectTitle());
                        // row.createCell(row.getRowNum()).setCellValue(current_proj.getRejected());
                        break;

                    case "Request": 
                        // Request current_req = (Request) result.get(row.getRowNum());
                        // row.createCell(row.getRowNum()).setCellValue(current_req.getProjectTitle());
                        // row.createCell(row.getRowNum()).setCellValue(current_req.getFromUser());
                        // row.createCell(row.getRowNum()).setCellValue(current_req.getStudent());
                        // break;
                        
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


    private static Student getStudent(String id){
        
        ArrayList<Object> studentList = readExcelFile("student_list.xlsx", new Student());
        
        // Load User Sub-class
        for (Object ob : studentList){
            Student stu = (Student) ob;
            if (stu.getUserID() == id){
                return stu;
            }
        }
        return new Student();
    }
    

    private static Supervisor getSupervisor(String id){
        
        ArrayList<Object> supervisorList = readExcelFile("faculty_list.xlsx", new Supervisor());
        
        // Load User Sub-class
        for (Object ob : supervisorList){
            Supervisor sup = (Supervisor) ob;

            if (sup.getUserID().compareTo(id) == 0){
                return sup;
            }
        }
        return new Supervisor();
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

