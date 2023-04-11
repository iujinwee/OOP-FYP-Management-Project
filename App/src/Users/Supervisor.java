package Users;

import java.util.*;

import Exceptions.*;
import Projects.Project;
import Requests.Request;
import Database.FYPCoordinatorDB;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.UserDetails.User;
import Users.UserDetails.UserType;

public class Supervisor extends User {

	private int numAssignedProjects=0;
	private int choice = -1;
	private int projectID=0;

	/**
	 * Supervisor constructor.
	 * 
	 * @param userID Unique ID of the supervisor.
	 * @param name Name of the supervisor.
	 * @param email Email address of the supervisor.
	 */
	public Supervisor(String userID, String name,String email) {
		super(userID, name, email);
		super.setUserType(UserType.SUPERVISOR); 
		this.sc = new Scanner(System.in);
	}
	public Supervisor() {}
	public int getNumAssignedProjects(){
		return this.numAssignedProjects;
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

			int projID; 

			// Load files
			loadFiles(reload);
			
			// Show Supervisor Menu
			viewUserMenu();
			// Get Input 
			System.out.println("\nEnter your option: ");
			choice = sc.nextInt();

			switch(choice){
				case 1: 
					System.out.println("Option [1] selected! - Create New Project.");
					projDB.createProject((Supervisor) this);
					break;

				case 2: 
					//Supervisor views his/her projects
					System.out.println("Option [2] selected! - View Projects created by me.");
					projDB.viewPersonalProjects(this);
					break;

				case 3:
					//Supervisor changes title of his/her projects
					System.out.println("Option [3] selected! - Change Title of Project.");
					projDB.viewPersonalProjects(this);
					System.out.println("Select Project ID for Title Change ");
					projectID = sc.nextInt();
					projDB.setNewTitle(projectID);
					break;

				case 4:	
					System.out.println("Option [4] selected! - Request to Transfer Student to Replacement Supervisor.");
					//get fyp coordinator id 
					FYPCoordinatorDB FYPdb = new FYPCoordinatorDB(); //to remove

					// View Projects
					projDB.viewProjects(this);
					System.out.println("Select Project to register:");
					projID = super.sc.nextInt();
					
					reqDB.createRequest(RequestType.CHANGESUPERVISOR,this, FYPdb.findInstance("ASFLI"), projID);	
					System.out.println("Request Sent.");
	
					//to check on missing link -> accept request -> enact change 			
					break;
					
				case 5:
					System.out.println("Option [5] selected! - Manage Incoming Requests.");
					reqDB.viewPendingRequests(this);
					// manageRequests();
					break;

				default:
					throw new InvalidInputException(choice);
			}
		}
	}

	// public void manageRequests() {

	// // 	Request curRequest = reqDB.getRequest(reqID); // return Subclass

	// 	Request currentReq = reqDB.findInstance(reqID);

	// 	System.out.println("Approve/ Reject");
	// 	System.out.println("[1] Approve");
	// 	System.out.println("[0] Reject");
	// 	int choice = sc.nextInt();

	// 	currentReq.enactRequest(choice);

	// 	reqDB.exportDB();

	// }


	
}