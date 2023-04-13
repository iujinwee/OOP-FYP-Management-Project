package Entity.UserClass;

import java.util.*;

import Controller.Request.CreateRequestController.NewRequest;
import Controller.Request.ViewRequestController.ControllerObject.ViewPendingRequests;
import Controller.Project.ModifyProjectController.ControllerObject.*;
import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Entity.DatabaseClass.FYPCoordinatorDB;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.*;
import Exceptions.*;


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
					changeSupervisor();
					break;
					
				case 5:
					System.out.println("Option [5] selected! - Manage Incoming Requests.");
					manageRequests();
					break;

				case 0: 
					break;
					
				default:
					throw new InvalidInputException(choice);
			}
		}
	}

	private void changeProjectTitle(){
		new ViewPersonalProjects(this);
		System.out.println("Select Project ID to change new title:");
		projectID = sc.nextInt();

		System.out.println("Enter the new title:");
		String newTitle = sc.next();

		new ChangeProjectTitle(projectID, newTitle);
	}

	private void changeSupervisor(){

		// View Projects
		new ViewPersonalProjects(this);
		System.out.println("Select Project ID to change new supervisor:");
		int projID = sc.nextInt();
						
		//get fyp coordinator id 
		FYPCoordinatorDB FYPdb = new FYPCoordinatorDB(); //to remove

		new NewRequest(RequestType.CHANGESUPERVISOR,this, FYPdb.findInstance(), projID);
		System.out.println("Request Sent.\n");

	}

	public void manageRequests() {

		if((new ViewPendingRequests(this)).requests.size() != 0){

			System.out.println("Select Request to manage: ");
			int reqID = sc.nextInt();

			// View requests 
			Request req = reqDB.findInstance(reqID);

			switch(req.getRequestType()){
				case CHANGESUPERVISOR:
					new ChangeProjectSupervisor(req.getProjectID(), req.getNewSupervisor());
					break;

				case CHANGETITLE: 
					new ChangeProjectTitle(req.getProjectID(), req.getNewTitle());
					break;

				case REGISTERPROJECT:
					new RegisterProject(req.getProjectID(), (Student) req.getFromUser());
					break;

				case DEREGISTERPROJECT: 
					new DeregisterProject(req.getProjectID(), (Student) req.getFromUser());
					break;
			}
		}
	}
}