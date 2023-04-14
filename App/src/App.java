import java.util.Scanner;

import Controller.Account.Login;
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

        // FYP_Coordinator m = new FYP_Coordinator("ASFLI", "LI FANG", "Y");
        // m.startProgram();
        
        User user = null;

        // Welcome Page
        new WelcomePage();

        // Login (Login with 5 attempts, use try, catch to handle invalid  inputs. once 5 attempts up, terminate program)
        new Login();

        // Initialising user class based on user type
        // switch(ca.getType()) {
        //     case "STUDENT":
        //         user = studentDB.findInstance(ca.getUserID());
        //         break;
        //     case "SUPERVISOR":
        //         user = supervisorDB.findInstance(ca.getUserID());
        //         break;
        //     case "FYPCOORDINATOR":
        //         user =  fyp_coordinatorDB.findInstance(ca.getUserID());
        //         break;
        // }
        
        // Show menu depending on user type
        // user.viewUserMenu();

    }
}