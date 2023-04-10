package Login;

public class Account {

	private String userID;
	private String password;

	public Account() {}

	/**
	 * Account constructor, created with default password
	 * @param userID Correct user ID of the account for login.
	 */
	public Account(String userID) {
		this.userID = userID;
		this.password = "password";	
	}
	
	/**
	 * Account constructor with both User ID and password specified
	 * @param userID Correct user ID of the account for login.
	 * @param password Correct password of the account for login.
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
	 * Changes password of the account.
	 * @param newPassword The new password after changing.
	 * @return Whether password successfully changed.
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
	 * Used to check whether password is correct, for successful log in. 
	 * @param inputPassword Password that user tries to input to login.
	 * @return Whether input password is correct.
	 */
	public boolean authenticate(String inputPassword) {
		if(inputPassword == this.password) {
			return true;
		} else {
			return false;
		}
	}

}