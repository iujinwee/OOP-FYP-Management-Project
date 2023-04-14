package Controller.Account;

import java.util.Scanner;

import Entity.AccountClass.Account;

public class Login extends LoadAccountDBController {
    
    private Account ca = new Account();
    private Account temp;
    private int loginAttempts;
    private String inputUserID;
    private String inputPassword;

    public Login() {
        loadFiles();
        header();
        loginAttempts = 1;
        while (loginAttempts <= 5) {
            getLoginInputs();
            if(checkUserID(inputUserID)) {
                if(checkPassword(inputPassword)) {
                    ca.setUserID(temp.getUserID());
			        ca.setPassword(temp.getPassword());
					ca.setType(temp.getType());
                    System.out.println("================= Login successful! =================");
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
        System.out.println("********************************************");
        System.out.println("************     LOGIN PAGE     ************");
        System.out.println("********************************************");
    }
    
    public void getLoginInputs() {
        Scanner sc = new Scanner(System.in);
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
