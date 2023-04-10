import java.util.Scanner;

import Database.AccountDB;
import Database.StudentDB;
import Database.SupervisorDB;
import Login.Account;
import Users.UserDetails.User;
import Users.Student;
import Users.Supervisor;
import Users.FYP_Coordinator;

public class App {

	public static void main(String[] args) {
        // StudentDB db = new StudentDB();
        // (db.findInstance("KOH1")).setName("YES");
        // System.out.println(db.findInstance("KOH1").getName());
        // db.exportDB();
        AccountDB accountDB = new AccountDB();
        // accountDB.showAccountDB();
        Account ca; 
        User user;

        // Introduction to App 
        System.out.println("\n================================================================");
        System.out.println("======    Welcome to Final Year Project Management App    ======");
        System.out.println("================================================================\n");

        // Login (Login with 5 attempts, use try, catch to handle invalid  inputs. once 5 attempts up, terminate program)
        String inputUserID;
        String inputPassword;
        int loginAttempts = 5;
        while(loginAttempts <= 5) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter User ID: ");
            inputUserID = sc.nextLine();
            System.out.println("Enter Password: ");
            inputPassword = sc.nextLine();

            Account temp = accountDB.findInstance(inputUserID);
            if(temp != null) {
                if(temp.authenticate(inputPassword)) {
                    ca = temp;
                    System.out.println("Log in successful");
                    break;
                } else {
                    System.out.println("Incorrect password!");
                }
            } else {
                System.out.println("Invalid user ID!");
            }
            
            loginAttempts++;
        }
        
        switch(ca.getType()) {
            case "STUDENT":
                user = new Student();
                break;
            case "SUPERVISOR":
                user = new Supervisor();
                break;
            case "FYPCOORDINATOR":
                user = new FYP_Coordinator();
                break;
        }
        

        // Show menu depending on user type
        

        // Execute choice of user
        // Changing password
	}
}