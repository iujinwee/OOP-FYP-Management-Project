package Users;
import java.util.*;

import Projects.ProjectDB;
import Requests.RequestDetails.Request;
import Requests.RequestDetails.RequestType;
import Users.ErrorHandler.InvalidInputException;
import Users.UserDetails.User;
import Users.UserDetails.UserType;
import Requests.RequestDB;

public class Student extends User{

	ArrayList<Request> sends;
	// Project registeredTo;
	private String studentID;
	private ProjectDB projDB;
	private RequestDB reqDB;
	private Scanner sc;

	/**
	 * 
	 * @param userID
	 * @param name
	 * @param email
	 */
	public Student(){}
	public Student(String userID, String name, String email) {

		// Initialization
		super(userID, name, email);
		super.setUserType(UserType.STUDENT);
		this.studentID = super.getUserID();
		this.sc = new Scanner(System.in);
		
		try{
			// Load Database
			projDB = new ProjectDB();
			reqDB = new RequestDB();
			getInput();

		}catch(InvalidInputException e){
			handleInvalidInputException(e);
			
		}catch(Exception e){
			System.out.println("Other Error: " + e.getMessage());
			
		// Clearing Program
		}finally{
			this.sc.close();
			System.exit(0);
		}

	}

	@Override
	public void viewUserMenu() {
		System.out.println("=============  MENU  ==============");
		System.out.println("[1] Show Available Projects.");
		System.out.println("[2] Show Registered Project.");
		System.out.println("[3] Register Project.");
		System.out.println("[4] Deregister Project.");
		System.out.println("[5] Change Assigned Project Title.");
		System.out.println("[0] Exit Program.");
	}
	
	public void viewRegisteredProject() {
		// TODO - implement Student.viewRegisteredProject
	}

	@Override
	public void getInput() throws InvalidInputException{
		int choice = sc.nextInt();

		while (choice != 0){
			// Show User Menu 
			viewUserMenu();
		
			// Get Input 
			System.out.println("\nEnter your option: ");
			
			// Exception for invalid input 

			switch(choice){
				case 1: 
					projDB.viewProjects(UserType.STUDENT);
					break;
				case 2: 
					viewRegisteredProject();
					break;
				case 3:
					reqDB.createRequest(RequestType.REGISTERPROJECT);
					break;
				case 4:
					reqDB.createRequest(RequestType.DEREGISTERPROJECT);
					break;
				case 5:
					reqDB.createRequest(RequestType.CHANGETITLE);
					break;
				case 0:
					System.out.println("Terminating Program...");
					break;

				default:
					throw new InvalidInputException(choice);
			}
		}
	}	

	@Override
	public void handleInvalidInputException(InvalidInputException e) {
		System.out.println("Invalid Input. Please select a valid option.\n");
		try{
			getInput();
		}catch(InvalidInputException error){
			System.out.println("2nd Invalid Input. Please try again later...");
			System.out.println("Terminating Program...");
			System.exit(0);
		}catch(Exception otherError){
			System.out.println("Other Exception: " + otherError.getMessage());
		}
	}	
}