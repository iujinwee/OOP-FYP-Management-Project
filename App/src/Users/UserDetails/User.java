package Users.UserDetails;

import Exceptions.InvalidInputException;

public abstract class User implements UserInterface {

	private String userID;
	private String name;
	private String email;
	private UserType type; 

	public User() {}
	
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

	public String getUserID() {
		return this.userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getType() {
		return this.type;
	}

	public void setType(UserType type){
		this.type = type;
	}
	
	@Override
	public void showMenu() {
		System.out.println("=======================================");
        System.out.println("   Welcome to FYP Management System!   ");
        System.out.println("=======================================");
        System.out.printf("You are currently signed in as a %s.\n", type);
   	}

	abstract public void viewUserMenu();
	abstract public void loadMenu(User user);
	abstract public void getInput(User user) throws InvalidInputException;
}