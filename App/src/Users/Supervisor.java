import java.util.*;

import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;
import Projects.ProjectDB;
import Projects.ProjectDetails.Project;
import Requests.RequestDB;
import Requests.RequestDetails.Request;
import Requests.RequestDetails.RequestType;
import Users.UserDetails.User;
import Users.UserDetails.UserType;
import Requests.RequestDetails.RequestStatus;

public class Supervisor extends User {

	Collection<Request> sends;
	Collection<Project> create;
	private String supervisorID;
	private int numAssignedProjects=0;
	private String input = null; 
	private int choice = -1;
	private ProjectDB projDB;
	private RequestDB reqDB;
	private Scanner sc;

	/**
	 * 
	 * @param userID
	 * @param name
	 */
	public Supervisor(String userID, String name,String email) {
		super(userID, name, email);
		super.setUserType(UserType.SUPERVISOR); 
		this.supervisorID = super.getUserID(); 
		this.sc = new Scanner(System.in);

	}
	public int getNumAssignedProjects(){
		return this.numAssignedProjects;
	}

	@Override
	public void loadMenu(){
		handleInvalidInput handler = new handleInvalidInput(sc);

		while(handler.checkAttempts()){
			try{
				// Load Database
				projDB = new ProjectDB();
				reqDB = new RequestDB();


				getInput();
				// Exit loop
				break;
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

		System.out.println("=============  SUPERVISOR MENU  ==============");
		System.out.println("[1] Create New Project");
		System.out.println("[2] View Projects created by me");
		System.out.println("[3] Change Title of Project");
		System.out.println("[4] Request to Transfer Student to Replacement Supervisor");
		System.out.println("[5] Manage Incoming Requests ");
		System.out.println("[0] Exit Program.");
	}

	@Override
	public void getInput() throws InvalidInputException{
		while (choice != 0){	

			// Show Supervisor Menu
			viewUserMenu();
			// Get Input 
			System.out.println("\nEnter your option: ");
			choice = sc.nextInt();

			switch(choice){
				case 1: 
					System.out.println("Option [1] selected! - Create New Project.");
					projDB.createProject(Supervisor);
					break;

				case 2: 
					//Supervisor views his/her projects
					System.out.println("Option [2] selected! - View Projects created by me.");
					projDB.viewProjects(supervisorID);
					break;

				case 3:
					//Supervisor changes title of his/her projects
					System.out.println("Option [3] selected! - Change Title of Project.");
					projDB.setProjectTitle(supervisorID);

					break;

				case 4:	
					System.out.println("Option [4] selected! - Request to Transfer Student to Replacement Supervisor.");
					reqDB.createRequest(RequestType.CHANGESUPERVISOR);					
				
					break;
					
				case 5:
					System.out.println("Option [5] selected! - Manage Incoming Requests.");
					manageRequests();
					break;

				default:
					throw new InvalidInputException(choice);
			}
		}
	}

	public void manageRequests() {
		// View all Requests (To include in sub-class)
		reqDB.viewRequest(this.supervisorID); //to change this method parameter in reqDB?

		//manage requests
		System.out.println("Enter RequestID to Approve/Reject: ");
		int reqID = sc.nextInt();

		Request curRequest = reqDB.getRequest(reqID); // return Subclass

		System.out.println("Approve/ Reject");
		System.out.println("[1] Approve");
		System.out.println("[0]");
		int choice = sc.nextInt();

		curRequest.enactRequest(choice);
	}

}