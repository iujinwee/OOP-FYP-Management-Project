package Controller.Account.ModifyAccountDB;

import java.util.Scanner;

import Boundaries.Menu.Interfaces.FooterInterface;
import Controller.Account.Login;
import Entity.AccountClass.Account;

public class ChangePassword extends ModifyAccountDB implements FooterInterface {

    private String userID;
    private String newPassword;
    public Scanner sc = new Scanner(System.in);

    /** 
     * Change Password Constructor.
     * @param userID Unique ID of User
     */
    public ChangePassword(String userID) {
        super();
        this.userID = userID;
        updateDB();
    }

    @Override
    public void updateDB() {
        Account temp =  accDB.findInstance(userID);
        System.out.printf("Enter New Password: ");
        this.newPassword = sc.next();
        
        if(newPassword.compareTo(temp.getPassword()) != 0) {
			temp.setPassword(newPassword);
			footer();
            exportDB();
            new Login();
		} else {
            System.out.println("\nERROR!");
			System.out.println("New password cannot be the same as old password.\n");
		}
    }

    @Override
    public void footer() {
        System.out.println("\n========= Password successfully changed. =========\n");
    }
}
