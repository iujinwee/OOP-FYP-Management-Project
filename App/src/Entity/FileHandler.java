package Entity;

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

import Entity.AccountClass.Account;
import Entity.DatabaseClass.StudentDB;
import Entity.DatabaseClass.SupervisorDB;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.FYP_Coordinator;
import Entity.UserClass.Student;
import Entity.UserClass.Supervisor;
import Entity.UserClass.UserDetails.User;

public class FileHandler {
    private final static String dataPath = "\\App\\data\\";
    private final static String macDataPath = "/App/data/";

    
    /** 
     * Method used to read excel file into an array list of objects.
     * @param filePath Path of excel file
     * @param item Object of excel file content
     * @return ArrayList<Object>
     */
    public static ArrayList<Object> readExcelFile(String filePath, Object item) {
        String pathname;
        StudentDB stu;
        SupervisorDB sup;
        String className;

        // Path Name
        final String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("mac") >= 0) {
            pathname = System.getProperty("user.dir").concat(macDataPath);

        } else {
            pathname = System.getProperty("user.dir").concat(dataPath);
        }

        String finalPath = pathname.concat(filePath);
        ArrayList<Object> resultList = new ArrayList<>();
        Map<String, Integer> columnMap = new HashMap<>();

        try {
            FileInputStream inputStream = new FileInputStream(new File(finalPath));
            XSSFWorkbook wb = new XSSFWorkbook(inputStream); // Create Workbook
            XSSFSheet sheet = wb.getSheetAt(0); // Change to Worksheet

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
                if (getStringCellValue(row.getCell(0)) == "") {
                    break;
                }

                className = item.getClass().getSimpleName();

                switch (className) {
                    case "Account":
                        String userID = getStringCellValue(row.getCell(columnMap.get("ID")));
                        String password = getStringCellValue(row.getCell(columnMap.get("password")));
                        String acctype = getStringCellValue(row.getCell(columnMap.get("type")));

                        Account tempAccount = (Account) item
                                .getClass()
                                .getDeclaredConstructor(String.class, String.class, String.class)
                                .newInstance(userID, password, acctype);
                        resultList.add(tempAccount);

                        break;

                    case "Student":
                        String stuid = getStringCellValue(row.getCell(columnMap.get("ID")));
                        String stuname = getStringCellValue(row.getCell(columnMap.get("Name")));
                        String stuemail = getStringCellValue(row.getCell(columnMap.get("Email")));
                        Boolean bool = Boolean.parseBoolean(getStringCellValue(row.getCell(columnMap.get("Assigned"))).toUpperCase());

                        Student tempStu = (Student) item
                                .getClass()
                                .getDeclaredConstructor(String.class, String.class, String.class, Boolean.class)
                                .newInstance(stuid, stuname, stuemail, bool);
                        resultList.add(tempStu);

                        break;

                    case "FYP_Coordinator":
                        String FYPid = getStringCellValue(row.getCell(columnMap.get("ID")));
                        String FYPname = getStringCellValue(row.getCell(columnMap.get("Name")));
                        String FYPemail = getStringCellValue(row.getCell(columnMap.get("Email")));

                        FYP_Coordinator tempFYP = (FYP_Coordinator) item
                                .getClass()
                                .getDeclaredConstructor(String.class, String.class, String.class)
                                .newInstance(FYPid, FYPname, FYPemail);
                        resultList.add(tempFYP);

                        break;
                        
                    case "Supervisor":
                        String id = getStringCellValue(row.getCell(columnMap.get("ID")));
                        String name = getStringCellValue(row.getCell(columnMap.get("Name")));
                        String email = getStringCellValue(row.getCell(columnMap.get("Email")));
                        int assigned = getNumericCellValue(row.getCell(columnMap.get("num_assigned")));

                        Supervisor tempUser = (Supervisor) item
                                .getClass()
                                .getDeclaredConstructor(String.class, String.class, String.class, int.class)
                                .newInstance(id, name, email, assigned);
                        resultList.add(tempUser);

                        break;

                    case "Project":
                        stu = new StudentDB();
                        sup = new SupervisorDB();

                        // Load Project Information
                        int projId = getNumericCellValue(row.getCell(columnMap.get("ID")));
                        String supId = getStringCellValue(row.getCell(columnMap.get("SupervisorID")));
                        String stuId = getStringCellValue(row.getCell(columnMap.get("StudentID")));
                        String title = getStringCellValue(row.getCell(columnMap.get("Title")));
                        String rejectString = getStringCellValue(row.getCell(columnMap.get("Rejected")));
                        ProjectStatus projStatus = ProjectStatus
                                .valueOf(getStringCellValue(row.getCell(columnMap.get("Status"))));
                        String[] rejectList = rejectString.split(",");
                        ArrayList<String> rejectStrList = new ArrayList<>(Arrays.asList(rejectList));

                        Project tempProject = (Project) item
                                .getClass()
                                .getDeclaredConstructor(int.class, String.class, Student.class, Supervisor.class,
                                        ProjectStatus.class, ArrayList.class)
                                .newInstance(projId, title, stu.findInstance(stuId), sup.findInstance(supId),
                                        projStatus, rejectStrList);

                        resultList.add(tempProject);

                        break;

                    case "Request":
                        stu = new StudentDB();
                        sup = new SupervisorDB();

                        int reqId = getNumericCellValue(row.getCell(columnMap.get("ID")));
                        String fromUserID = getStringCellValue(row.getCell(columnMap.get("fromUser")));
                        String toUserID = getStringCellValue(row.getCell(columnMap.get("toUser")));
                        RequestType type = RequestType.valueOf(getStringCellValue(row.getCell(columnMap.get("type"))));
                        RequestStatus reqStatus = RequestStatus
                                .valueOf(getStringCellValue(row.getCell(columnMap.get("status"))));
                        int projID = getNumericCellValue(row.getCell(columnMap.get("projectID")));
                        String newTitle = getStringCellValue(row.getCell(columnMap.get("newTitle")));
                        String newSupervisor = getStringCellValue(row.getCell(columnMap.get("newSupervisor")));

                        User fromUser;
                        User toUser;

                        fromUser = stu.findInstance(fromUserID);
                        if(fromUser.getUserID() == null){
                            fromUser = sup.findInstance(fromUserID);
                        }
                        toUser = sup.findInstance(toUserID);

                        Request tempRequest = (Request) item
                                .getClass()
                                .getDeclaredConstructor(int.class, User.class, User.class, RequestStatus.class,
                                        RequestType.class, int.class)
                                .newInstance(reqId, fromUser, toUser, reqStatus, type, projID);

                        if (newTitle != "") {
                            tempRequest.setNewTitle(newTitle);
                        }

                        if (newSupervisor != "") {
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

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in Reading Files.");
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            System.out.println("Error in Reading Files.");
        }
        return resultList;
    }

    /** 
     * Method used to save and update excel file
     * @param filePath Path of excel file
     * @param result 
     * @return boolean
     */
    public static boolean saveExcelFile(String filePath, ArrayList<Object> result) {
        // Path Name
        String pathname;
        String className;

        // Path Name
        final String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("mac") >= 0) {
            pathname = System.getProperty("user.dir").concat(macDataPath);

        } else {
            pathname = System.getProperty("user.dir").concat(dataPath);
        }
        String finalPath = pathname.concat(filePath);
        boolean saveFile = true;

        try {
            FileInputStream inputStream = new FileInputStream(new File(finalPath));
            XSSFWorkbook wb = new XSSFWorkbook(inputStream); // Create Workbook
            XSSFSheet sheet = wb.getSheetAt(0); // Change to Worksheet

            // write header row to create column map
            int row_count = 0;
            for (Object item : result) {
                Row row = sheet.getRow(row_count + 1);
                if (row == null) {
                    row = sheet.createRow(row_count + 1);
                }

                int column_count = 0;

                className = item.getClass().getSimpleName();
                if((className.contains("Request") )|| (className.contains("Enact"))){
                    className = "Request";
                }
     
                switch (className) {
                    case "Account":
                        Account current_account = (Account) result.get(row_count++);
                        row.createCell(column_count++).setCellValue((String) current_account.getUserID());
                        row.createCell(column_count++).setCellValue((String) current_account.getPassword());
                        row.createCell(column_count++).setCellValue((String) current_account.getType());
                        break;
                        
                    case "Student":
                        Student current_stu = (Student) result.get(row_count++);
                        row.createCell(column_count++).setCellValue((String) current_stu.getUserID());
                        row.createCell(column_count++).setCellValue((String) current_stu.getName());
                        row.createCell(column_count++).setCellValue((String) current_stu.getEmail());
                        row.createCell(column_count++).setCellValue(current_stu.getAssigned() ? "TRUE" : "FALSE");
                        break;

                    case "FYP_Coordinator":
                    case "Supervisor":
                        Supervisor current_user = (Supervisor) result.get(row_count++);
                        row.createCell(column_count++).setCellValue((String) current_user.getUserID());
                        row.createCell(column_count++).setCellValue((String) current_user.getName());
                        row.createCell(column_count++).setCellValue((String) current_user.getEmail());
                        row.createCell(column_count++).setCellValue(current_user.getNumAssignedProjects());
                        break;

                    case "Project":
                        Project current_proj = (Project) result.get(row_count++);
                        
                        StringBuilder sb = new StringBuilder();
                        for (String s : current_proj.getRejected()) {
                            if (!s.isEmpty() && sb.indexOf(s) == -1) {
                                sb.append(s).append(",");
                            }
                        }
                        String rejected = sb.toString();

                        row.createCell(column_count++).setCellValue(current_proj.getProjectID());
                        row.createCell(column_count++).setCellValue(current_proj.getProjectTitle());
                        row.createCell(column_count++).setCellValue(current_proj.getStudentID());
                        row.createCell(column_count++).setCellValue(current_proj.getSupervisorID());
                        row.createCell(column_count++).setCellValue(current_proj.getProjectStatus().toString());
                        row.createCell(column_count++).setCellValue(rejected);
                        break;

                    case "Request":
                        Request current_req = (Request) result.get(row_count++);

                        String type = "";

                        if (current_req.getRequestType() != null) {
                            type = current_req.getRequestType().toString();
                        }

                        String status = "";
                        if (current_req.getRequestStatus() != null) {
                            status = current_req.getRequestStatus().toString();
                        }

                        row.createCell(column_count++).setCellValue(current_req.getRequestID());
                        row.createCell(column_count++).setCellValue(current_req.getfromUserID());
                        row.createCell(column_count++).setCellValue(current_req.gettoUserID());
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

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in Saving Files.");
        }
        return saveFile;
    }

    /** 
     * Method used to get cell value in string format.
     * @param cell 
     * @return String
     */
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

    /** 
     * Method used to get cell value in numeric format.
     * @param cell 
     * @return int
     */
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
