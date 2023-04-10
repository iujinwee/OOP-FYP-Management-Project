import java.util.Scanner;

import Database.StudentDB;
import Login.Account;
import Users.Student;

public class App {

	public static void main(String[] args) {
        // StudentDB db = new StudentDB();
        // (db.findInstance("KOH1")).setName("YES");
        // System.out.println(db.findInstance("KOH1").getName());
        // db.exportDB();

        // Introduction to App 
        System.out.println("\n================================================================");
        System.out.println("======    Welcome to Final Year Project Management App    ======");
        System.out.println("================================================================\n");


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
}