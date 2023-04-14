package Entity.UserClass;

import java.util.*;

import Controller.Project.ModifyProjectController.ControllerObject.*;
import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Controller.Request.CreateRequestController.ControllerObject.NewChangeSupervisorRequest;
import Controller.Request.ManageRequestController.*;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewIncomingRequestsHistory;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewOutgoingRequestsHistory;
import Entity.UserClass.UserDetails.*;
import Exceptions.*;

public class Supervisor extends User {

	private int numAssignedProjects=0;
	private int choice = -1;

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

		System.out.println("=============  SUPERVISOR MENU  ==============");
		System.out.println("[1] Create New Project");
		System.out.println("[2] View Projects created by me");
		System.out.println("[3] Change Title of Project");
		System.out.println("[4] Request to Transfer Student to Replacement Supervisor");
		System.out.println("[5] Manage Incoming Requests ");
		System.out.println("[6] View all incoming and outgoing requests");
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
					new CreateProject(this);
					break;

				case 2: 
					//Supervisor views his/her projects
					System.out.println("Option [2] selected! - View Projects created by me.");
					new ViewPersonalProjects(this);
					break;

				case 3:
					//Supervisor changes title of his/her projects
					System.out.println("Option [3] selected! - Change Title of Project.");
					changeProjectTitle();
					break;

				case 4:	
					System.out.println("Option [4] selected! - Request to Transfer Student to Replacement Supervisor.");
					new NewChangeSupervisorRequest(this);
					break;
					
				case 5:
					System.out.println("Option [5] selected! - Manage Incoming Requests.");
					new RequestManager(this);
					break;

				case 6:
					System.out.println("Option [6] selected! - View all incoming and outgoing requests.");
					new ViewIncomingRequestsHistory(this);
					new ViewOutgoingRequestsHistory(this);
					break;

				case 0: 
					break;
					
				default:
					throw new InvalidInputException(choice);
			}
		}
	}

	private void changeProjectTitle() throws InvalidInputException{
		// View Projects
		ViewPersonalProjects projs = new ViewPersonalProjects(this);

		System.out.println("Select Project ID to change new title:");
		int projID = sc.nextInt();

		boolean own = projs.projects.contains(projID);
		if(own){	
			System.out.println("Enter the new title:");
			String newTitle = sc.next();
			new ChangeProjectTitle(projID, newTitle);

		}else{
			throw new InvalidInputException(projID);
		}
	}

	public void addAssignedProjects(){
		this.numAssignedProjects = this.numAssignedProjects + 1;
	}

	public void removeAssignedProjects(){
		this.numAssignedProjects = this.numAssignedProjects - 1;
	}

}