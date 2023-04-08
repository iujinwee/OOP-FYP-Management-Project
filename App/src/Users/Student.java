package Users;
import java.util.*;

import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;
import Projects.ProjectDB;
import Requests.RequestDetails.Request;
import Requests.RequestDetails.RequestType;
import Users.UserDetails.User;
import Users.UserDetails.UserType;
import Requests.RequestDB;

public class Student extends User{

	ArrayList<Request> sends;
	// Project registeredTo;
	private final static int MAX_ATTEMPTS = 3; 
	private int attempts = 0;
	private int choice = -1;
	private String studentID;
	private ProjectDB projDB;
	private RequestDB reqDB;
	private Scanner sc;

	/**
	 * Represents a Student. 
	 * 
	 * @param userID represents the unique ID of the student.
	 * @param name represents the name of the student.
	 * @param email represents the email of the student.
	 */
	public Student(){}
	public Student(String userID, String name, String email) {

		// Initialization
		super(userID, name, email);
		super.setUserType(UserType.STUDENT);
		this.studentID = super.getUserID();
		this.sc = new Scanner(System.in);
	}

	@Override
	public void loadMenu() {

		handleInvalidInput handler = new handleInvalidInput(sc);

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
	public void viewUserMenu() {
		System.out.println("=============  MENU  ==============");
		System.out.println("[1] Show Available Projects.");
		System.out.println("[2] Show Registered Project.");
		System.out.println("[3] Register Project.");
		System.out.println("[4] Deregister Project.");
		System.out.println("[5] Change Assigned Project Title.");
		System.out.println("[6] View All Requests.");
		System.out.println("[0] Exit Program.");
	}
	
	public void viewRegisteredProject() {
		// TODO - implement Student.viewRegisteredProject
	}

	@Override
	public void getInput() throws InvalidInputException{

		while (choice != 0){	
			
			// Show User Menu
			viewUserMenu();

			// Get Input 
			System.out.println("\nEnter your option: ");
			choice = sc.nextInt();

			switch(choice){
				case 1: 
					System.out.println("Option [1] selected! - Show Available Projects");
					projDB.viewProjects(UserType.STUDENT);
					break;
				case 2: 
					System.out.println("Option [2] selected! - Show Registered Project.");
					viewRegisteredProject();
					break;
				case 3:
					System.out.println("Option [3] selected! - Register Project.");
					reqDB.createRequest(RequestType.REGISTERPROJECT);
					break;
				case 4:	
					System.out.println("Option [4] selected! - Deregister Project.");
					reqDB.createRequest(RequestType.DEREGISTERPROJECT);
					break;
				case 5:
					System.out.println("Option [5] selected! - Change Assigned Project Title.");
					reqDB.createRequest(RequestType.CHANGETITLE);
					break;

				case 6: 
					System.out.println("Option [6] selected!");
					reqDB.viewRequest(this.studentID);
					break;				

				default:
					throw new InvalidInputException(choice);
			}
		}
	}	
}