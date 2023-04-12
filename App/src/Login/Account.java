package Login;

import java.util.Scanner;

import Database.AccountDB;

public class Account {

	private String userID;
	private String password;
	private String type;
	public Scanner sc = new Scanner(System.in);

	public Account() {}

	/**
	 * Account constructor, created with default password
	 * @param userID Correct user ID of the account for login.
	 */
	public Account(String userID, String type) {
		this.userID = userID;
		this.password = "password";	
		this.type = type;
	}
	
	/**
	 * Account constructor with both User ID and password specified
	 * @param userID Correct user ID of the account for login.
	 * @param password Correct password of the account for login.
	 * @param type Account type, which will then correspond to user type.
	 */
	public Account(String userID, String password, String type) {
		this.userID = userID;
		this.password = password;
		this.type = type; 
	}

	public String getUserID() {
		return this.userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean login(AccountDB accDB) {
        int loginAttempts = 1;
        while(loginAttempts <= 5) {
            System.out.println("Enter User ID: ");
            String inputUserID = sc.nextLine();
            System.out.println("Enter Password: ");
            String inputPassword = sc.nextLine();

            Account temp = accDB.findInstance(inputUserID);
            if(temp.getUserID() != null) {
                if(temp.authenticate(inputPassword)) {
                    this.setUserID(temp.getUserID());
					this.setPassword(temp.getPassword());
					this.setType(temp.getType());
                    System.out.println("Log in successful");
                    return true;
                } else {
                    System.out.println("Incorrect password!");
                }
            } else {
                System.out.println("Invalid user ID!");
            }
            
            loginAttempts++;
        }
		return false;
	}

	/**
	 * Changes password of the account.
	 * @param newPassword The new password after changing.
	 * @return Whether password successfully changed.
	 */
	public boolean changePassword(AccountDB accDB) {
		
		System.out.println("Enter new password: ");
		String newPassword = sc.nextLine();
		if(newPassword != this.password) {
			this.password = newPassword;
			accDB.exportDB();
			System.out.println("Password successfully changed");
			return true;
		} else {
			System.out.println("New password cannot be the same as old password");
			return false;
		}
	}

	/**
	 * Used to check whether password is correct, for successful log in. 
	 * @param inputPassword Password that user tries to input to login.
	 * @return Whether input password is correct.
	 */
	public boolean authenticate(String inputPassword) {
		if(inputPassword.compareTo(this.password) == 0) {
			return true;
		} else {
			return false;
		}
	}
}