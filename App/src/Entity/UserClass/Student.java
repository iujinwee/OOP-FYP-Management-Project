package Entity.UserClass;

import Controller.Project.ViewProjectController.ViewAvailableProjects;
import Controller.Project.ViewProjectController.ViewPersonalProjects;
import Controller.Request.CreateRequestController.NewRequest;
import Controller.Request.ViewRequestController.ControllerObject.ViewOutgoingRequestsHistory;
import Entity.DatabaseClass.FYP_CoordinatorDB;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.*;
import Exceptions.InvalidInputException;

public class Student extends User {
 	
	private String studentID;
	// private boolean assigned; 
	public Student() {}

	/**
	 * Student constructor. 
	 * 
	 * @param userID Unique ID of the student.
	 * @param name Name of the student.
	 * @param email Email address of the student.
	 */
	public Student(String userID, String name, String email) {
		super(userID, name, email);
		super.setUserType(UserType.STUDENT);
		this.studentID = super.getUserID();
	}

	// GETTER FUNCTIONS
	public String getStudentID() {
		return this.studentID;
	}

	// SETTER FUNCTIONS
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	

	@Override
	public void getInput() throws InvalidInputException{

		Account acc;
		boolean loggedin = true;
		loadFiles(reload);
		reload = false;
		int choice = -1;

		while (choice != 0 && loggedin){	

			// Show User Menu
			viewUserMenu();

			// Get Input 
			System.out.printf("\nEnter Option: ");
			choice = sc.nextInt();

			switch(choice){
				case 1: 
					System.out.println("\nOption [1] selected! - Show Available Projects");
					new ViewAvailableProjects(this);
					break;

				case 2: 
					System.out.println("\nOption [2] selected! - Show Registered Project.");
					new ViewPersonalProjects(this);
					break;

				case 3:
					System.out.println("\nOption [3] selected! - Register Project.");
					registerProject();
					break;

				case 4:	
					System.out.println("\nOption [4] selected! - Deregister Project.");
					deregisterProject();
					break;

				case 5:
					System.out.println("\nOption [5] selected! - Change Assigned Project Title.");
					changeTitle();
					break;

				case 6: 
					System.out.println("\nOption [6] selected! - View All Requests");
					viewAllRequests();
					break;
				
				case 7:
					System.out.println("\nOption [7] selected! - Change Password");
					changePassword();
					acc = accDB.findInstance(this.getUserID());
					boolean changed = acc.changePassword(accDB);
					if(changed){
						loggedin = acc.login(accDB);
					}
					break;

				case 0: 
					System.out.println("Option [0] selected! - Exit Program");
					break;

				default:
					throw new InvalidInputException(choice);
			}
		}
	}	

	private void registerProject() throws InvalidInputException{
		ViewAvailableProjects projs = new ViewAvailableProjects(this);

		// View Projects
		if(projs.projects.size()!=0){
			System.out.printf("Select Project to register: ");
			int projID = sc.nextInt();
			
			if(projs.projects.contains(projID)){
				FYP_CoordinatorDB FYPDB = new FYP_CoordinatorDB();
				new NewRequest(RequestType.REGISTERPROJECT, this, FYPDB.findInstance(), projID);
			}else{
				throw new InvalidInputException(projID);
			}
		}
	}

	private void deregisterProject() throws InvalidInputException{
		ViewPersonalProjects projs = new ViewPersonalProjects(this);
		// View Projects
		if(projs.projects.size()!=0){
			System.out.println("Select Project to deregister:");
			int projID = super.sc.nextInt();
			
			if(projs.projects.contains(projID)){
				FYPCoordinatorDB FYPDB = new FYPCoordinatorDB();
				new NewRequest(RequestType.DEREGISTERPROJECT, this, FYPDB.findInstance(), projID);
			}else{
				throw new InvalidInputException(projID);
			}
		}
	}

	private void changeTitle() throws InvalidInputException{
		ViewPersonalProjects projs = new ViewPersonalProjects(this);
		// View Projects
		if(projs.projects.size()!=0){
			System.out.printf("Select Assigned Project to change title: ");
			int projID = super.sc.nextInt();
			
			if(projs.projects.contains(projID)){
				new NewRequest(RequestType.CHANGETITLE, this, projDB.findInstance(projID).getSupervisor(), projID);
			}else{
				throw new InvalidInputException(projID);
			}
		}
	}

	private void changePassword (){
		System.out.println("Enter new password: ");
		String newPassword = sc.nextLine();
	}

	private void viewAllRequests(){
		new ViewOutgoingRequestsHistory(this);
	}
}