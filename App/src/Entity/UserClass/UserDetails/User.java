package Entity.UserClass.UserDetails;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Database.LoadFilesInterface;
import Boundaries.Menu.GetInputInterface;
import Boundaries.Menu.UserProgramInterface;
import Entity.DatabaseClass.ProjectDB;
import Entity.DatabaseClass.RequestDB;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class User implements GetInputInterface, UserProgramInterface, LoadFilesInterface {

	private String userID;
	private String name;
	private String email;
	public Scanner sc = new Scanner(System.in);
	public handleInvalidInput menuHandler = new handleInvalidInput(3);
	private UserType type;

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

        System.out.printf("You are currently signed in as a %s.\n\n", type);

		while(menuHandler.checkAttempts()){
			try{
				getInput();
				break; // Break out of loop

			}catch(InvalidInputException e){
				menuHandler.handleInvalidInputException(e);

			}catch(InputMismatchException e){
				menuHandler.handleInputMismatchException(e);
				sc.nextLine();
			}
		}
		// Clearing System
		System.out.println("Terminating Program...");
		sc.close();
		System.exit(0);
   	}
}