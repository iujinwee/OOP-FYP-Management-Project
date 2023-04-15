package Entity.AccountClass;

import java.util.Scanner;

public class Account {

	private String userID;
	private String password;
	private String type;
	public Scanner sc = new Scanner(System.in);

	public Account() {}

	/**
	 * Account constructor, created with default password.
	 * @param userID Correct user ID of the account for login
	 * @param type Account type, which will then correspond to user type
	 */
	public Account(String userID, String type) {
		this.userID = userID;
		this.password = "password";	
		this.type = type;
	}
	
	/**
	 * Account constructor with both User ID and password specified.
	 * @param userID Correct user ID of the account for login
	 * @param password Correct password of the account for login
	 * @param type Account type, which will then correspond to user type
	 */
	public Account(String userID, String password, String type) {
		this.userID = userID;
		this.password = password;
		this.type = type; 
	}

	
	// GETTER FUNCTIONS
	/** 
	 * Method used to get unique user ID.
	 * @return String
	 */
	public String getUserID() {
		return this.userID;
	}

	/** 
	 * Method used to get account password.
	 * @return String
	 */
	public String getPassword() {
		return this.password;
	}

	/** 
	 * Method used to get account type.
	 * @return String
	 */
	public String getType() {
		return this.type;
	}

	//SETTER FUNCTIONS
	/** 
	 * Method used to set unique ID of user.
	 * @param userID Unique ID of user
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/** 
	 * Method used to set account password.
	 * @param password Account password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** 
	 * Method used to set account type.
	 * @param type Account type
	 */
	public void setType(String type) {
		this.type = type;
	}
}