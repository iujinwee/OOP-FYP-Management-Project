package Controller.Account;

import java.util.Scanner;

import Boundaries.Menu.FooterInterface;
import Boundaries.Menu.HeaderInterface;
import Controller.User.InitializeUser;
import Entity.AccountClass.Account;

public class Login extends LoadAccountDBController implements HeaderInterface, FooterInterface {
    
    private Account acc = new Account();
    private Account temp;
    private String inputUserID;
    private String inputPassword;

    public Login() {
        super();
        
        header();
        int loginAttempts = 1;
        while (loginAttempts <= 3) {
            getLoginInputs();
            if(checkUserID(inputUserID)) {
                if(checkPassword(inputPassword)) {
                    setupAccount();
                    footer();
                    new InitializeUser(acc);
                    break;
                } else {
                    System.out.println("\nIncorrect Password!");
                }
            } else {
                System.out.println("\nInvalid User ID!");
            }
            
            loginAttempts++;
        }
    }
    
    @Override
    public void header() {
        System.out.println("\n********************************************");
        System.out.println("************     LOGIN PAGE     ************");
        System.out.println("********************************************");
    }

    @Override
    public void footer() {
        System.out.println("================= Login successful! =================");
    }
    
    public void getLoginInputs() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n>LOGIN");
        System.out.printf("Enter User ID: ");
        this.inputUserID = sc.nextLine();
        System.out.printf("Enter Password: ");
        this.inputPassword = sc.nextLine();
    }

    
    /** 
     * @param inputUserID
     * @return boolean
     */
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
