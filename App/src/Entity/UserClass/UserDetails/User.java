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
	 * User constructor
	 * @param userID Unique user ID of the user, the part of the email before @
	 * @param name Name of the user
	 * @param email Email address of the user
	 */
	public User(String userID, String name, String email) {
		this.userID = userID;
		this.name = name;
		this.email = email;
	}

	// GETTER FUNCTIONS
	public String getUserID() {
		return this.userID;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public UserType getUserType(){
		return this.type;
	}

	// SETTER FUNCTIONS
	public void setUserID(String id) {
		this.userID = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserType(UserType type){
		this.type = type;
	}

}
