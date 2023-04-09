package FileManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Projects.ProjectDetails.Project;
import Requests.RequestDetails.Request;
import Users.Student;
import Users.Supervisor;
import Users.UserDetails.User;
import Login.Account;

public class FileReader {
    
    public static ArrayList<Object> readExcelFile(String filePath, Object item) {
        
        // Path Name 
        String pathname = System.getProperty("user.dir").concat("\\data\\");
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

