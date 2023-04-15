package Controller.Account.ModifyAccountDBController;

import java.util.Scanner;

import Boundaries.Menu.FooterInterface;
import Controller.Account.Login;
import Entity.AccountClass.Account;

public class ChangePassword extends ModifyAccountDBController implements FooterInterface {

    private String userID;
    private String newPassword;

    public ChangePassword(String userID) {
        super();
        this.userID = userID;
        updateDB();
    }

    @Override
    public void updateDB() {
        Account temp =  accDB.findInstance(userID);

        Scanner sc = new Scanner(System.in);
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
