package Controller.User;

import Boundaries.Menu.Classes.FYP_CoordinatorMenu;
import Boundaries.Menu.Classes.StudentMenu;
import Boundaries.Menu.Classes.SupervisorMenu;
import Entity.AccountClass.Account;
import Entity.UserClass.Student;
import Entity.UserClass.Supervisor;
import Entity.UserClass.FYP_Coordinator;

public class InitializeUser extends LoadUsersDB {
    
    public InitializeUser(Account acc) {
        super();
        System.out.printf("You are currently signed in as a %s.\n\n", acc.getType());
        switch(acc.getType()){
            case "STUDENT":
                Student student = stuDB.findInstance(acc.getUserID());
                new StudentMenu(student);
                break;
            case "SUPERVISOR":
                Supervisor supervisor = supDB.findInstance(acc.getUserID());
                new SupervisorMenu(supervisor);
                break;
            case "FYPCOORDINATOR":
                FYP_Coordinator fyp_coordinator = fyp_coordDB.findInstance(acc.getUserID());
                new FYP_CoordinatorMenu(fyp_coordinator);
                break;
        }

        // Clearing System
		System.out.println("Terminating Program...");
		System.exit(0);
    }
}
