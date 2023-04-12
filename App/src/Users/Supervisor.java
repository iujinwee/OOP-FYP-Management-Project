package Users;

import java.util.*;

import Exceptions.*;
import Projects.ProjectClasses.ChangeProjectSupervisor;
import Projects.ProjectClasses.ChangeProjectTitle;
import Projects.ProjectClasses.CreateProject;
import Projects.ProjectClasses.DeregisterProject;
import Projects.ProjectClasses.RegisterProject;
import Projects.ViewProjectsPackage.ViewPersonalProjects;
import Database.FYPCoordinatorDB;
import Requests.NewRequest;
import Requests.Request;
import Requests.RequestType;
import Requests.RequestClasses.ChangeSupervisorRequest;
import Requests.RequestClasses.ChangeTitleRequest;
import Requests.RequestClasses.DeregisterProjectRequest;
import Requests.RequestClasses.RegisterProjectRequest;
import Requests.ViewRequestsPackage.ViewPendingRequests;
import Requests.enactRequestsPackage.EnactChangeSupervisor;
import Requests.enactRequestsPackage.EnactChangeTitle;
import Requests.enactRequestsPackage.EnactDeregisterProject;
import Requests.enactRequestsPackage.EnactRegisterProject;
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

		new ChangeProjectSupervisor(projID, );	
		System.out.println("Request Sent.\n");

		//to check on missing link -> accept request -> enact change 			
		reload = true;
	}

	public void manageRequests() {

		if((new ViewPendingRequests(this)).count != 0){

			System.out.println("Select Request to manage: ");
			int reqID = sc.nextInt();

			System.out.println("Approve or Reject Request? [1] Approve [0] Reject");
			int choice = sc.nextInt();

			// View requests 
			Request req = reqDB.findInstance(reqID);

			

			switch(req.getRequestType()){
				case CHANGESUPERVISOR:
					new EnactChangeSupervisor(reqID).enactRequest(choice);
					break;

				case CHANGETITLE: 
					new EnactChangeTitle(reqID).enactRequest(choice);
					break;

				case REGISTERPROJECT:
					new EnactRegisterProject(reqID).enactRequest(choice);
					break;

				case DEREGISTERPROJECT: 
					new EnactDeregisterProject(reqID).enactRequest(choice);
					break;
			}
		}
	}
}