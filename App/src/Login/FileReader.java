package Login;
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
import Users.UserDetails.User;

public class FileReader {
    
    public static ArrayList<Object> readExcelFile(String filePath, Object item) {
        
        // Path Name 
        String pathname = System.getProperty("user.dir").concat("/App/data/");
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
                    case "Student":
                    case "Supervisor":
                        User tempUser = (User) item.getClass().getDeclaredConstructor().newInstance();

                        String email  = getStringCellValue(row.getCell(columnMap.get("Email")));

                        tempUser.setUserID(email.substring(0, email.indexOf('@')));
                        tempUser.setName(getStringCellValue(row.getCell(columnMap.get("Name"))));
                        tempUser.setEmail(email);
                        resultList.add(tempUser);

                        break;

                    case "Project":
                        Project tempProject = (Project) item.getClass().getDeclaredConstructor().newInstance();

                        tempProject.setProjectTitle(getStringCellValue(row.getCell(columnMap.get("Title"))));
                        tempProject.setSupervisor(getStringCellValue(row.getCell(columnMap.get("Supervisor"))));
                        resultList.add(tempProject);

                        break;

                    case "Request": 
                        Request tempRequest = (Request) item.getClass().getDeclaredConstructor().newInstance();
                        

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
    
    private static double getNumericCellValue(Cell cell) {
        double value = 0;
        if (cell != null) {
            switch (cell.getCellType()) {
                case NUMERIC:
                    value = cell.getNumericCellValue();
                    break;
                case FORMULA:
                    value = cell.getNumericCellValue();
                    break;
                default:
                    break;
            }
        }
        return value;
    }
}

