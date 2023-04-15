package Entity.UserClass;

import java.util.*;

// import Controller.Request.CreateRequestController.NewRequest;
// import Controller.Request.ViewRequestController.ControllerObject.ViewPendingRequests;
// import Controller.Project.ModifyProjectController.ControllerObject.*;
// import Controller.Project.ViewProjectController.ViewPersonalProjects;
// import Entity.DatabaseClass.FYP_CoordinatorDB;
// import Entity.RequestClass.Request;
// import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.*;
// import Exceptions.*;

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
	public Supervisor(String userID, String name, String email, int numAssigned) {
		super(userID, name, email);
		this.numAssignedProjects = numAssigned;
		super.setUserType(UserType.SUPERVISOR); 
		this.supervisorID = super.getUserID();
	}

	// GETTER FUNCTIONS
	public String getSupervisorID() {
		return this.supervisorID;
	}

	public int getNumAssignedProjects(){
		return this.numAssignedProjects;
	}
	

	public void setNumAssignedProjects(int numAssigned) {
		this.numAssignedProjects = numAssigned;
	}

	// private void changeProjectTitle(){
	// 	new ViewPersonalProjects(this);
	// 	System.out.println("Select Project ID to change new title:");
	// 	projectID = sc.nextInt();

	// 	System.out.println("Enter the new title:");
	// 	String newTitle = sc.next();

	// 	new ChangeProjectTitle(projectID, newTitle);
	// }

	// private void changeSupervisor(){

	// 	// View Projects
	// 	new ViewPersonalProjects(this);
	// 	System.out.println("Select Project ID to change new supervisor:");
	// 	int projID = sc.nextInt();
						
	// 	//get fyp coordinator id 
	// 	FYP_CoordinatorDB FYPdb = new FYP_CoordinatorDB(); //to remove

	// 	new NewRequest(RequestType.CHANGESUPERVISOR,this, FYPdb.findInstance(), projID);
	// 	System.out.println("Request Sent.\n");

	// }

	// public void manageRequests() {

	// 	if((new ViewPendingRequests(this)).requests.size() != 0){

	// 		System.out.println("Select Request to manage: ");
	// 		int reqID = sc.nextInt();

	// 		// View requests 
	// 		Request req = reqDB.findInstance(reqID);

	// 		switch(req.getRequestType()){
	// 			case CHANGESUPERVISOR:
	// 				new ChangeProjectSupervisor(req.getProjectID(), req.getNewSupervisor());
	// 				break;

	// 			case CHANGETITLE: 
	// 				new ChangeProjectTitle(req.getProjectID(), req.getNewTitle());
	// 				break;

	// 			case REGISTERPROJECT:
	// 				new RegisterProject(req.getProjectID(), (Student) req.getFromUser());
	// 				break;

	// 			case DEREGISTERPROJECT: 
	// 				new DeregisterProject(req.getProjectID(), (Student) req.getFromUser());
	// 				break;
	// 		}
	// 	}
	// }
}