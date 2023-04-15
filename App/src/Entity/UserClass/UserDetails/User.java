package Entity.UserClass.UserDetails;

import java.util.Scanner;

public class User {

	private String userID;
	private String name;
	private String email;
	private UserType type;

	public Scanner sc = new Scanner(System.in);

	public User(){};
	
	/**
	 * User constructor.
	 * @param userID Unique user ID of the user.
	 * @param name Name of the user.
	 * @param email Email address of the user.
	 */
	public User(String userID, String name, String email) {
		this.userID = userID;
		this.name = name;
		this.email = email;
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
	 * Method used to get name of user..
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

	/** 
	 * Method used to get email address of user.
	 * @return String
	 */
	public String getEmail() {
		return this.email;
	}

	/** 
	 * Method used to get type of user (student, supervisor, FYP coordinator).
	 * @return String
	 */
	public UserType getUserType(){
		return this.type;
	}

	// SETTER FUNCTIONS
	/** 
	 * Method used to set unique user ID.
	 * @param id Unique user ID of the user to be set
	 */
	public void setUserID(String id) {
		this.userID = id;
	}

	/** 
	 * Method used to set name of user.
	 * @param name Name of user to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * Method used to set email address of user.
	 * @param email Email address of user to be set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 
	 * Method used to set type of user.
	 * @param type Type of user to be set (student, supervisor, FYP coordinator)
	 */
	public void setUserType(UserType type){
		this.type = type;
	}

}
