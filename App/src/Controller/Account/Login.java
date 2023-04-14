package Controller.Account;

import java.util.Scanner;

import Controller.User.InitializeUser;
import Entity.AccountClass.Account;

public class Login extends LoadAccountDBController {
    
    private Account acc = new Account();
    private Account temp;
    private String inputUserID;
    private String inputPassword;
    private Scanner sc = new Scanner(System.in);

    public Login() {
        loadFiles();
        accDB.viewDB(); // only for debugging and trialing purposes
        header();
        int loginAttempts = 1;
        while (loginAttempts <= 5) {
            getLoginInputs();
            if(checkUserID(inputUserID)) {
                if(checkPassword(inputPassword)) {
                    acc.setUserID(temp.getUserID());
			        acc.setPassword(temp.getPassword());
					acc.setType(temp.getType());
                    System.out.println("================= Login successful! =================");
                    
                    new InitializeUser(acc);
                    break;
                } else {
                    System.out.println("Incorrect Passwprd!");
                }
            } else {
                System.out.println("Invalid User ID!");
            }
            
            loginAttempts++;
        } 
    }
    
    public void header() {
        System.out.println("\n********************************************");
        System.out.println("************     LOGIN PAGE     ************");
        System.out.println("********************************************\n");
    }
    
    public void getLoginInputs() {
        System.out.println("Enter User ID: ");
        inputUserID = sc.nextLine();
        System.out.println("Enter Password: ");
        inputPassword = sc.nextLine();
    }

    public boolean checkUserID(String inputUserID) {
        temp = accDB.findInstance(inputUserID);
        if(temp.getUserID() != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkPassword(String inputPassword) {
		if(inputPassword.compareTo(temp.getPassword()) == 0) {
			return true;
		} else {
			return false;
		}
	}
}
