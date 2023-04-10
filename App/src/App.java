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
import Requests.RequestDetails.Request;

public class App {

	private static ArrayList<Object> studentList;
	private static ArrayList<Object> facultyList;
	private static ArrayList<Object> projectList;
	private static ArrayList<Object> coordinator;
	private static ArrayList<Object> requestList;

	public static void main(String[] args) {
		// File Initialization
        initalizeSystem();

        // Introduction to App 
        System.out.println("\n================================================================");
        System.out.println("======    Welcome to Final Year Project Management App    ======");
        System.out.println("================================================================\n");

        // Login (Login with 5 attempts, use try, catch to handle invalid  inputs. once 5 attempts up, terminate program)
        int loginAttempts = 1;
        boolean loginSuccess = login();
        while(!loginSuccess && loginAttempts <= 5){
            login();
            loginAttempts++;
        }

        // Show menu depending on user type
        
        // Execute choice of user
	}

	
    private static boolean login(){
        String inputUserID;
        String inputPassword;
        Account account;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User ID: ");
        inputUserID = sc.nextLine();
        System.out.println("Enter Password: ");
        inputPassword = sc.nextLine();

        // if (account = AccountDB.findAcc()) {
            // account.authenticate(inputPassword);
            // return true;
        // } else {
            // print "invalid user id"
            // return false;
        // }
        
    }

    // Do we really need this, mayb just need to initialize whenever loading the class
    private static void initalizeSystem(){ 

        try{
            System.out.println("Initializing Files...");

            // scan in student list file 
            studentList = FileReader.readExcelFile("student_list.xlsx", new Student());

            // TO BE DELETED, JUST TO CHECK
            Student x = (Student) studentList.get(0);
            System.out.println(x.getUserID());
            
            // scan in faculty list file
            
            // scan in fyp coordinator file


            // scan in rollover project list file
            // projectList = FileReader.readExcelFile("rollover_project.xlsx", new Project());

            // // // TO BE DELETED, JUST TO CHECK
            // Project y = (Project) projectList.get(0);
            // y.viewAllocatedProjectDetails();


            // requestList = FileReader.readExcelFile("requestList", new Request());


            System.out.println("Files Initialized!");

        }catch(Exception e){
            System.out.println("Error in Initializing File");
            e.printStackTrace();
        }
    }
}