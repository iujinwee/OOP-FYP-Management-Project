import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Login.Account;
import Login.FileReader;
import Projects.ProjectDetails.Project;
import Users.FYP_Coordinator;
import Users.Student;
import Users.Supervisor;

public class App {

	private static ArrayList<Object> studentList;
	private static ArrayList<Supervisor> facultyList;
	private static ArrayList<Project> projectList;
	private static ArrayList<FYP_Coordinator> coordinator;
	private static ArrayList<Account> accountsList;

	public static void main(String[] args) {
		// File Initialization
        initalizeSystem();

        // Introduction to App 
        System.out.println("\n================================================================");
        System.out.println("======    Welcome to Final Year Project Management App    ======");
        System.out.println("================================================================\n");


        // Login (Login with 5 attempts, use try, catch to handle invalid  inputs. once 5 attempts up, terminate program)
        // boolean loginSuccess = login();
        // while(!loginSuccess){
        //     login();
        // }

        // Show menu depending on user type
        
        
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

            Student x = (Student) studentList.get(0);
            System.out.println(x.getUserID());
            
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