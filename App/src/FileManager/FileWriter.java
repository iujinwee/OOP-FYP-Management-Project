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
import Users.UserDetails.User;

public class FileWriter {
    public static boolean saveExcelFile(String filePath, ArrayList<Object> result) {
        // Path Name 
        String pathname = System.getProperty("user.dir").concat("\\data\\");
        String finalPath = pathname.concat(filePath);
        Map<String, Integer> columnMap = new HashMap<>();
        boolean saveFile = true;

        try {
            FileInputStream inputStream = new FileInputStream(new File(finalPath));
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);   // Create Workbook
            XSSFSheet sheet = wb.createSheet(result.getClass().getSimpleName());  // Change to Worksheet
            
            // write header row to create column map
            int row_count = 0;
            for (Object item: result) {
                Row row = sheet.createRow(++row_count);

                int column_count = 0;

                switch (item.getClass().getSimpleName()) {
                    case "Student":
                    case "Supervisor":
                    case "FYP_Coordinator":
                        
                        User current_user = (User) result.get(row.getRowNum());
                        row.createCell(++column_count).setCellValue((String) current_user.getUserID());
                        row.createCell(++column_count).setCellValue((String) current_user.getName());
                        row.createCell(++column_count).setCellValue((String) current_user.getEmail());
                        break;

                    case "Project":
                        Project current_proj = (Project) result.get(row.getRowNum());
                        row.createCell(row.getRowNum()).setCellValue(current_proj.getSupervisorId());
                        row.createCell(row.getRowNum()).setCellValue(current_proj.getProjectTitle());
                        row.createCell(row.getRowNum()).setCellValue(current_proj.getStudentId());
                        break;

                    case "Request": 
                        Request current_req = (Request) result.get(row.getRowNum());
                        row.createCell(row.getRowNum()).setCellValue(current_req.getProjectTitle());
                        row.createCell(row.getRowNum()).setCellValue(current_req.getFromUser());
                        row.createCell(row.getRowNum()).setCellValue(current_req.getStudent());
                        break;
                        
                    default:
                        saveFile = false;
                        break;
                }
            }
            
            wb.write();
            inputStream.close();

        }catch(IOException e){
            e.printStackTrace();
            
        } catch (ReflectiveOperationException e){
            e.printStackTrace();
        }
        return saveFile;
    
}
    