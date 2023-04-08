import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import FileManager.FileReader;
import Login.Account;
import Users.FYP_Coordinator;
import Users.Student;
import Users.Supervisor;
import Projects.ProjectDB;
import Projects.ProjectDetails.Project;

public class App {

	private static ArrayList<Object> studentList;
	private static ArrayList<Supervisor> facultyList;
	private static ArrayList<Object> projectList;
	private static ArrayList<FYP_Coordinator> coordinator;
	private static ArrayList<Account> accountsList;

	public static void main(String[] args) {
		// File Initialization
        // initalizeSystem();

        // Introduction to App 
        System.out.println("\n================================================================");
        System.out.println("======    Welcome to Final Year Project Management App    ======");
        System.out.println("================================================================\n");

        Student x = new Student("wee","Eugene", "wee@ntu.sg");
        Supervisor y = new Supervisor("gan", "Bgan", "B@.t");
        // ProjectDB projectList = new ProjectDB();
        // projectList.createProject("Yes", "Y", null);

        Project p = new Project(1, "Content", x, y);
        p.viewAllocatedProjectDetails();
        p.viewAvailableProjectDetails();

        // Student x = new Student("wee","Eugene", "wee@ntu.sg");
        // x.loadMenu();

        // // Login (Login with 5 attempts, use try, catch to handle invalid  inputs. once 5 attempts up, terminate program)
        // boolean loginSuccess = login();
        // while(!loginSuccess){
        //     login();
        // }

        // Show menu depending on user type
        Supervisor a = new Supervisor("null", "d",  "s");
        a.loadMenu();
        
        // Execute choice of user
	}

	
    private static boolean login(){
        String inputUserID;
        String inputPassword;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user ID: ");
        inputUserID = sc.nextLine();
        System.out.println("Enter Password: ");
        inputPassword = sc.nextLine();

        if (inputPassword!="" /*inputUserID exists in file*/) {
            String userID = inputUserID;
            String password = inputPassword /* correct password */ ;
            Account account = new Account(userID, password);
            // account.authenticate(accountList, inputPassword);
            return true;
        }
        // error handling
        else {
            System.out.println("Invalid user ID!");
            return false;
        }
    }

    // Do we really need this, mayb just need to initialize whenever loading the class
    private static void initalizeSystem(){ 

        try{
            System.out.println("Initializing Files...");

            // scan in student list file 
            studentList = FileReader.readExcelFile("student_list.xlsx", new Student());

            // // TO BE DELETED, JUST TO CHECK
            // Student x = (Student) studentList.get(0);
            // System.out.println(x.getUserID());
            
            // scan in faculty list file

            // scan in rollover project list file

            // scan in fyp coordinator file


            System.out.println("Files Initialized!");

        }catch(Exception e){
            System.out.println("Error in Initializing File");
            e.printStackTrace();
        }
    }
}