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

import Users.UserDetails.User;

public class FileReader {
    
    public static ArrayList<User> readExcelFile(String filePath, User user) throws IOException {
        ArrayList<User> userList = new ArrayList<>();
        Map<String, Integer> columnMap = new HashMap<>();

        try {
            FileInputStream inputStream = new FileInputStream(new File(filePath));
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
                User tempUser = user.getClass().getDeclaredConstructor().newInstance();
                tempUser.setUserID(getStringCellValue(row.getCell(0)));
                System.out.println(getStringCellValue(row.getCell(0)));
                tempUser.setName(getStringCellValue(row.getCell(columnMap.get("Name"))));
                tempUser.setEmail(getStringCellValue(row.getCell(columnMap.get("Email"))));
            
                userList.add(tempUser);
            }
            
            wb.close();
            inputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        } catch (ReflectiveOperationException e){
            e.printStackTrace();
        }
        return userList;
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

