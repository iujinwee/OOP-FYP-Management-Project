import java.util.Scanner;

import Database.AccountDB;
import Database.FYPCoordinatorDB;
import Database.StudentDB;
import Database.SupervisorDB;
import Login.Account;
import Users.UserDetails.User;

public class App {

	public static void main(String[] args) {
        AccountDB accDB = new AccountDB();
        StudentDB studentDB = new StudentDB();
        SupervisorDB supervisorDB = new SupervisorDB();
        FYPCoordinatorDB fypCoordinatorDB = new FYPCoordinatorDB();
        accDB.showDB();
        // studentDB.showDB();
        Account ca = new Account(); 
        User user = null;
        Scanner sc = new Scanner(System.in);

        // Introduction to App 
        System.out.println("\n================================================================");
        System.out.println("======    Welcome to Final Year Project Management App    ======");
        System.out.println("================================================================\n");

        // Login (Login with 5 attempts, use try, catch to handle invalid  inputs. once 5 attempts up, terminate program)
        ca.login(accDB);

        // Initialising user class based on user type
        switch(ca.getType()) {
            case "STUDENT":
                user = studentDB.findInstance(ca.getUserID());
                break;
            case "SUPERVISOR":
                user = supervisorDB.findInstance(ca.getUserID());
                break;
            case "FYPCOORDINATOR":
                user =  fypCoordinatorDB.findInstance(ca.getUserID());
                break;
        }
        
        // Show menu depending on user type
        user.startProgram();
        user.viewUserMenu();

        sc.close();
	}
}