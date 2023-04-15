package Controller.Account.AccessAccountDBController;

import Controller.Account.Login;
import Entity.AccountClass.Account;
import Entity.DatabaseClass.AccountDB;

public class ChangePassword extends AccessAccountDBController {

    private String userID;
    private String newPassword;

    public ChangePassword(String userID, String newPassword) {
        this.userID = userID;
        this.newPassword = newPassword;
        loadFiles();
        updateDB();
    }
    
    @Override
    public void loadFiles() {
        accDB = new AccountDB();
    }

    @Override
    public void updateDB() {
        Account temp =  accDB.findInstance(userID);
        if(newPassword.compareTo(temp.getPassword()) != 0) {
			temp.setPassword(newPassword);
			System.out.println("========= Password successfully changed. =========");
            exportDB();
            new Login();
		} else {
            System.out.println("\nERROR!");
			System.out.println("New password cannot be the same as old password.\n");
		}
    }
    
}
