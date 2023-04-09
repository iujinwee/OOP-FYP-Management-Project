package Login;

public class Account {

	private String userID;
	private String password;

	public Account() {}

	/**
	 * Represents an Account, created with default password
	 * 
	 * @param userID represents correct user ID of the account for login.
	 */
	public Account(String userID) {
		this.userID = userID;
		this.password = "password";	
	}
	
	/**
	 * Represents an Account
	 * 
	 * @param userID represents correct user ID of the account for login.
	 * @param password represents correct password of the account for login.
	 */
	public Account(String userID, String password) {
		this.userID = userID;
		this.password = password;
	}

	public String getUserID() {
		return this.userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * 
	 * @param newPassword represents new password after changing.
	 */
	public boolean changePassword(String newPassword) {
		if(newPassword != this.password) {
			this.password = newPassword;
			System.out.println("Password successfully changed");
			return true;
		} else {
			System.out.println("New password cannot be the same as old password");
			return false;
		}
	}

	/**
	 * 
	 * @param inputPassword represents the password that user tries to input to login
	 */
	public boolean authenticate(String inputPassword) {
		if(inputPassword == this.password) {
			return true;
		} else {
			return false;
		}
	}

}