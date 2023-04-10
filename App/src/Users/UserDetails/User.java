package Users.UserDetails;

import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class User implements UserInterface {

	private String userID;
	private String name;
	private String email;
	private Scanner sc;
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
		this.sc = new Scanner(System.in);
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

	public void setType(UserType type) {
		this.type = type;
	}



	public void startProgram() {
		handleInvalidInput handler = new handleInvalidInput(sc, 3);

        System.out.printf("You are currently signed in as a %s.\n\n", type);

		while(handler.checkAttempts()){
			try{
				getInput();
				break; // Break out of loop

			}catch(InvalidInputException e){
				handler.handleInvalidInputException(e);

			}catch(InputMismatchException e){
				handler.handleInputMismatchException(e);

			}
		}
		// Clearing System
		System.out.println("Terminating Program...");
		this.sc.close();
		System.exit(0);
   	}
}