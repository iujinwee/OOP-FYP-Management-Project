import java.util.*;

import Projects.ProjectDB;
import Projects.ProjectDetails.Project;
import Requests.RequestDB;
import Requests.RequestDetails.Request;
import Requests.RequestDetails.RequestType;
import Requests.RequestDetails.RequestStatus;
import Users.UserDetails.User;
import Users.UserDetails.UserType;
import Users.UserRole.Administrator;

public class Supervisor extends User implements Administrator  {

	Collection<Request> sends;
	Collection<Project> create;
	private String supervisorID;
	private int numAssignedProjects;
	private int projectLimit = 2;
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
					/*move to ProjDB */
					// System.out.println("Enter Project Title: ");
					// String ProjegctTitle = sc.nextLine();
					projDB.createProject(supervisorID);
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

					/*to move to ProjDB*/
					// System.out.println("Enter ProjectID: ");
					// int projectID = sc.nextInt();
					// System.out.println("Enter New Project Title: ");
					// String NewProjectTitle = sc.nextLine();
					
					break;

				case 4:	
					System.out.println("Option [4] selected! - Request to Transfer Student to Replacement Supervisor.");
					reqDB.createRequest(RequestType.CHANGESUPERVISOR);
					sends.add();
					
					/*to move to ReqDB*/
					// System.out.println("Enter ProjectID: ");
					// int projectID = sc.nextInt();
					// System.out.println("Enter Replacement Supervisor ID: ");
					// String ReplacementSupID = sc.nextLine();
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

	@Override
	public void manageRequests() {
		// View all Requests (To include in sub-class)
		reqDB.viewAllRequests(SupervisorID); //to change this method parameter in reqDB?

		//manage requests
		System.out.println("Enter RequestID to Approve/Reject: ");
		int reqID = sc.nextInt();
		System.out.println("Select one \n [1] Approve [2] Reject ");
		choice = sc.nextInt();
		if (choice==1){ 
			approve(reqID); 
		}else{
			reject(reqID);
		}

	}

	@Override
	public Boolean createProject() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createProject'");
	}

	@Override
	public Boolean changeTitle() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'changeTitle'");
	}

	@Override
	public void approve(Request request) {
		//update request status 
		request.SetRequestStatus(REJECTED);

		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'approve'");

	}

	@Override
	public void reject(Request request) {
		request.SetRequestStatus(REJECTED);

		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'reject'");
	}
	}
}