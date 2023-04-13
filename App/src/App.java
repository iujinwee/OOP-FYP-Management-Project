import java.util.Scanner;

import Controller.ViewUserMenuController.WelcomePage;
import Entity.AccountClass.Account;
import Entity.DatabaseClass.AccountDB;
import Entity.DatabaseClass.StudentDB;
import Entity.DatabaseClass.SupervisorDB;
import Entity.UserClass.FYP_Coordinator;
import Entity.UserClass.Student;
import Entity.UserClass.Supervisor;
import Entity.UserClass.UserDetails.User;

public class App {

	public static void main(String[] args) {

        new WelcomePage();

        Supervisor u = new Supervisor("ASMADHUKUMAR", "A S Madhukumar", "ASMADHUKUMAR@NTU.EDU.SG", 2);
        u.startProgram();

<<<<<<< HEAD
        // Student u = new StudentDB().findInstance("YCHERN");
        // u.startProgram();
=======
        Student u = new Student("CT113", "CALVIN", "Test");
        u.startProgram();

        new WelcomePage();
>>>>>>> 54a51fb (Limit No. Register Project Request feature)

        // FYP_Coordinator m = new FYP_Coordinator("ASFLI", "LI FANG", "Y");
        // m.startProgram();

        AccountDB accountDB = new AccountDB();
        StudentDB studentDB = new StudentDB();
        SupervisorDB supervisorDB = new SupervisorDB();
        // accountDB.showDB();
        // studentDB.showDB();
        Account ca = null; 
        User user = null;
        Scanner sc = new Scanner(System.in);

        // Introduction to App 
        System.out.println("\n================================================================");
        System.out.println("======    Welcome to Final Year Project Management App    ======");
        System.out.println("================================================================\n");

        // Login (Login with 5 attempts, use try, catch to handle invalid  inputs. once 5 attempts up, terminate program)
        String inputUserID;
        String inputPassword;
        int loginAttempts = 5;
        
        while(loginAttempts <= 5) {
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
        
        // Initialising user class based on user type
        switch(ca.getType()) {
            case "STUDENT":
                user = studentDB.findInstance(ca.getUserID());
                break;
            case "SUPERVISOR":
                user = supervisorDB.findInstance(ca.getUserID());
                break;
            case "FYPCOORDINATOR":
                user = new FYP_Coordinator();
                break;
        }
        
        // Show menu depending on user type
        user.startProgram();
        // user.viewUserMenu();

        // Execute choice of user
        // Changing password

        sc.close();
	}
}