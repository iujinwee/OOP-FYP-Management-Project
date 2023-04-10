package Database;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database {
    public Object currentInstance;
    public int currentIndex; 
    public ArrayList<Object> objectDB; 
    public int size; 
    private String filePath;
    public Scanner sc = new Scanner(System.in);

    public Database(String filePath, Object o){
        this.filePath = filePath;

        try{
            // System.out.printf("Initializing %s Files...\n", o.getClass().getSimpleName());
            this.objectDB = FileHandler.readExcelFile(filePath, o);
            // System.out.println("Files Initialized!");
        }catch(Exception e){
            System.out.println("Error in Initializing File");
            // e.printStackTrace();
        }

        this.size = objectDB.size();

    }

    public void exportDB(){
        FileHandler.saveExcelFile(filePath, objectDB);
    }
}
