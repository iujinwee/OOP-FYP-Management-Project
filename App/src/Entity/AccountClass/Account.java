package Entity.AccountClass;

import java.util.Scanner;

public class Account {

	private String userID;
	private String password;
	private String type;
	public Scanner sc = new Scanner(System.in);

	public Account() {}

	/**
	 * Account constructor, created with default password
	 * @param userID Correct user ID of the account for login.
	 * @param type Account type, which will then correspond to user type.
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

	// GETTER FUNCTIONS
	public String getUserID() {
		return this.userID;
	}

	public String getPassword() {
		return this.password;
	}

	public String getType() {
		return this.type;
	}

	//SETTER FUNCTIONS
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setType(String type) {
		this.type = type;
	}
}