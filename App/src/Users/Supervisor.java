package Users;

import java.util.*;

import Exceptions.*;
import Database.FYPCoordinatorDB;
import Requests.ChangeSupervisor;
import Requests.ChangeTitle;
import Requests.DeregisterProject;
import Requests.RegisterProject;
import Requests.Request;
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
	public Supervisor(String userID, String name,String email, int numAssigned) {
		super(userID, name, email);
		this.numAssignedProjects = numAssigned;
		super.setUserType(UserType.SUPERVISOR); 
		this.sc = new Scanner(System.in);
	}
	public Supervisor() {}
	public int getNumAssignedProjects(){
		return this.numAssignedProjects;
	}
	
		
	@Override
	public void viewUserMenu() {

		System.out.println("\n=============  SUPERVISOR MENU  ==============");
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
			reload = false;
			
			// Show Supervisor Menu
			viewUserMenu();
			// Get Input 
			System.out.println("\nEnter your option: ");
			choice = sc.nextInt();

			switch(choice){
				case 1: 
					System.out.println("Option [1] selected! - Create New Project.");
					projDB.createProject(this);
					reload = true;
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
					reload = true;
					break;

				case 4:	
					System.out.println("Option [4] selected! - Request to Transfer Student to Replacement Supervisor.");
	
					// View Projects
					projDB.viewProjects(this);
					System.out.println("Select Project to Change Supervisor:");
					projID = super.sc.nextInt();
									
					//get fyp coordinator id 
					FYPCoordinatorDB FYPdb = new FYPCoordinatorDB(); //to remove
				
					reqDB.createRequest(RequestType.CHANGESUPERVISOR, this, FYPdb.findInstance("ASFLI"), projID);	
					System.out.println("Request Sent.\n");
	
					//to check on missing link -> accept request -> enact change 			
					reload = true;
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

		reqDB.viewPendingRequests(this);

		System.out.println("Select Request to manage: ");
		int reqID = sc.nextInt();

		// View requests 
		Request req = reqDB.findInstance(reqID);
		reqDB.viewRequest(req);

		System.out.println("\n> Approve/ Reject");
		System.out.println("[1] Approve");
		System.out.println("[0] Reject");

		switch(req.getRequestType()){
			case CHANGESUPERVISOR:
				ChangeSupervisor cs = (ChangeSupervisor) req;
				cs.enactRequest(sc.nextInt());
				break;

			case CHANGETITLE: 
				ChangeTitle ct = (ChangeTitle) req;
				ct.enactRequest(sc.nextInt());
				break;

			case REGISTERPROJECT:
				RegisterProject rp = (RegisterProject) req;
				rp.enactRequest(sc.nextInt());
				break;

			case DEREGISTERPROJECT: 
				DeregisterProject dp = (DeregisterProject) req;
				dp.enactRequest(sc.nextInt());
				break;
		}

		reqDB.exportDB();
		reload = true;
	}
	
}