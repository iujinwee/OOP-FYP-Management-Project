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
        header();
        int loginAttempts = 1;
        while (loginAttempts <= 5) {
            getLoginInputs();
            if(checkUserID(inputUserID)) {
                if(checkPassword(inputPassword)) {
                    setupAccount();
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
        sc.close();
    }
    
    public void header() {
        System.out.println("********************************************");
        System.out.println("************     LOGIN PAGE     ************");
        System.out.println("********************************************");
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

    public void setupAccount() {
        acc.setUserID(temp.getUserID());
		acc.setPassword(temp.getPassword());
		acc.setType(temp.getType());
    }
}
