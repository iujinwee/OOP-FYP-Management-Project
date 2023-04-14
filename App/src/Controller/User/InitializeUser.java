package Controller.User;

import Entity.AccountClass.Account;
import Entity.UserClass.UserDetails.User;

public class InitializeUser extends LoadUsersDBController {

    private User user;
    
    public InitializeUser(Account acc) {
        loadFiles();
        switch(acc.getType()){
            case "STUDENT":
                user = stuDB.findInstance(acc.getUserID());
                break;
            case "SUPERVISOR":
                user = supDB.findInstance(acc.getUserID());
                break;
            case "FYPCOORDINATOR":
                user = fypcoordDB.findInstance(acc.getUserID());
                break;
        }
        user.startProgram();
    }
}
