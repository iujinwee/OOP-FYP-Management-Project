import java.util.Scanner;

import Controller.ViewUserMenuController.WelcomePage;
import Entity.AccountClass.Account;
import Entity.DatabaseClass.AccountDB;
import Entity.DatabaseClass.StudentDB;
import Entity.DatabaseClass.SupervisorDB;
import Entity.DatabaseClass.FYP_CoordinatorDB;
import Entity.UserClass.FYP_Coordinator;
import Entity.UserClass.Student;
import Entity.UserClass.UserDetails.User;

public class App {

	public static void main(String[] args) {
        // Supervisor u = new Supervisor("ASFLI", "A S Madhukumar", "E@ntu.sg", 0);
        // u.startProgram();

        // Student u = new Student("YCHERN", "CHERN", "Test");
        // u.startProgram();

        new WelcomePage();

        // FYP_Coordinator m = new FYP_Coordinator("ASFLI", "LI FANG", "Y");
        // m.startProgram();

        AccountDB accDB = new AccountDB();
        StudentDB studentDB = new StudentDB();
        SupervisorDB supervisorDB = new SupervisorDB();
        FYP_CoordinatorDB fyp_coordinatorDB = new FYP_CoordinatorDB();
        accDB.viewDB();
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
                user =  fyp_coordinatorDB.findInstance(ca.getUserID());
                break;
        }
        
        // Show menu depending on user type
        user.startProgram();
        user.viewUserMenu();

        sc.close();
	}
}