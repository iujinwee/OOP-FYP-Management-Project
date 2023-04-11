package Users.UserDetails;

import java.util.InputMismatchException;
import java.util.Scanner;

import Database.ProjectDB;
import Database.RequestDB;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class User implements UserInterface {

	private String userID;
	private String name;
	private String email;
	public Scanner sc;
	public ProjectDB projDB;
	public RequestDB reqDB;
	public boolean reload = false;
	UserType type;

	/**
	 * User constructor
	 * @param userID Unique user ID of the user, the part of the email before @
	 * @param name Name of the user
	 * @param email Email address of the user
	 */

	public User(){};
	
	public User(String userID, String name, String email) {
		this.userID = userID;
		this.name = name;
		this.email = email;
	}

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

	@Override
	public void startProgram() {
		sc = new Scanner(System.in);
		handleInvalidInput handler = new handleInvalidInput(sc, 3);

        System.out.printf("You are currently signed in as a %s.\n", type);

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

	@Override
	public void loadFiles(boolean reload) {
					
		if(projDB==null | reqDB==null){
			// Load DB 
			System.out.println("Initializing Files...");
			projDB = new ProjectDB();
			reqDB = new RequestDB();
			System.out.println("Files Initialized.");
		}
	}
}