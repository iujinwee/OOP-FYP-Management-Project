import java.util.Scanner;

import Login.Account;
import Users.User;
import Users.Student;

public class App {
    public static void main(String[] args){
        
        // File Initialization
        initalizeSystem();

        // Intro 

        // Login
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

        User a = Student("1","1","1");

        // if (/*inputUserID exists in file*/) {
        //     String userID = inputUserID;
        //     String password = /* correct password */ ;
        //     Account account = new Account(userID, password);
        //     account.authenticate(accountList, inputPassword);
        // }
        // else {
        //     System.out.println("Invalid user ID!");
        //     return false;
        // }
    }

    private static void initalizeSystem(){ 
        // scan in student list file 
        // scan in faculty list file
        // scan in rollover project list file
        // scan in fyp coordinator file
    }

    private static void loadFile(){
        Scanner sc = new Scanner(System.in);
        // read file
    }
    
}
