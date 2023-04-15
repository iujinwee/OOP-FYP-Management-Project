package Entity.DatabaseClass;

import java.util.ArrayList;
import java.util.Scanner;

import Entity.FileHandler;

public abstract class Database {
    public Object currentInstance;
    public int currentIndex; 
    public ArrayList<Object> objectDB; 
    public int size; 
    private String filePath;
    public Scanner sc = new Scanner(System.in);

    /**
	 * Database constructor.
	 * @param filePath Path to excel file
	 * @param o Object
	 */
    public Database(String filePath, Object o){
        this.filePath = filePath;

        try{
            this.objectDB = FileHandler.readExcelFile(filePath, o);
        }catch(Exception e){
            System.out.println("Error in Initializing File");
        }
        this.size = objectDB.size();
    }

    public void exportDB(){
        FileHandler.saveExcelFile(filePath, objectDB);
    }
}
