import java.util.ArrayList;
import java.util.Scanner;

import Login.Account;
import Projects.Project.Project;
import Users.FYP_Coordinator;
import Users.Student;
import Users.Supervisor;

public class App {

	private ArrayList<Student> studentList;
	private ArrayList<Supervisor> facultyList;
	private ArrayList<Project> projectList;
	private ArrayList<FYP_Coordinator> coordinator;
	private ArrayList<Account> accountsList;

	public static void main(String[] args) {
		// File Initialization
        initalizeSystem();

        // Introduction to App 

        // Login (Login with 5 attempts, use try, catch to handle invalid  inputs. once 5 attempts up, terminate program)
        boolean loginSuccess = login();
        while(!loginSuccess){
            login();
        }

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

        if (/*inputUserID exists in file*/) {
            String userID = inputUserID;
            String password = /* correct password */ ;
            Account account = new Account(userID, password);
            account.authenticate(accountList, inputPassword);
        }
        // error handling
        else {
            System.out.println("Invalid user ID!");
            return false;
        }
    }

    private static void initalizeSystem(){ 
        // scan in student list file 
        // scan in faculty list file
        // scan in rollover project list file
        // scan in fyp coordinator file
    }

	/**
	 * 
	 * @param inputFile
	 */
	private ArrayList<Object> loadFile(FileIO inputFile) {
		// TODO - implement App.loadFile
		throw new UnsupportedOperationException();
	}

}