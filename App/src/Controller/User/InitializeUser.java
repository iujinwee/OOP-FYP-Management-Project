package Controller.User;

import Boundaries.Menu.StartProgramInterface;
import Controller.User.UserMenuController.*;
import Entity.AccountClass.Account;
import Entity.UserClass.Student;
import Entity.UserClass.Supervisor;
import Entity.UserClass.FYP_Coordinator;

public class InitializeUser extends LoadUsersDBController implements StartProgramInterface {

    private Account acc;
    
    public InitializeUser(Account acc) {
        loadFiles();
        
        this.acc = acc;
        startProgram();
    }

    public void startProgram() {

        System.out.printf("You are currently signed in as a %s.\n\n", acc.getType());
        switch(acc.getType()){
            case "STUDENT":
                Student student = stuDB.findInstance(acc.getUserID());
                new StudentMenu(student);
                break;
            case "SUPERVISOR":
                Supervisor supervisor = supDB.findInstance(acc.getUserID());
                // new SupervisorMenu(supervisor);
                break;
            case "FYPCOORDINATOR":
                user = fypcoordDB.findInstance(acc.getUserID());
                break;
        }

        // Clearing System
		System.out.println("Terminating Program...");
		System.exit(0);
    }

}
