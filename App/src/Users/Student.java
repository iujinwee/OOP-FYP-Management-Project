package Users;

import Database.FYPCoordinatorDB;
import Exceptions.InvalidInputException;
import Login.Account;
import Projects.Project;
import Projects.ProjectStatus;
import Projects.ViewProjectsPackage.ViewAvailableProjects;
import Projects.ViewProjectsPackage.ViewPersonalProjects;
import Users.UserDetails.*;
import Requests.NewRequest;
import Requests.RequestStatus;
import Requests.RequestType;
import Requests.ViewRequestsPackage.ViewOutgoingRequestsHistory;

public class Student extends User{
 	
	private String studentID;
	private boolean assigned; 
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
	}
	
	@Override
	public void viewUserMenu() {
		System.out.println("\n=============  MENU  ==============");
		System.out.println("[1] Show Available Projects.");
		System.out.println("[2] Show Registered Project.");
		System.out.println("[3] Register Project.");
		System.out.println("[4] Deregister Project.");
		System.out.println("[5] Change Assigned Project Title.");
		System.out.println("[6] View All Requests.");
		System.out.println("[7] Change Password.");
		System.out.println("[0] Exit Program.");
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
			System.out.println("\nEnter your option: ");
			choice = super.sc.nextInt();

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

	private void registerProject(){
		
		// View Projects
		if((new ViewAvailableProjects(this)).count!=0){
			System.out.println("Select Project to register:");
			int projID = super.sc.nextInt();

			FYPCoordinatorDB FYPDB = new FYPCoordinatorDB();
			
			new NewRequest(RequestType.REGISTERPROJECT, this, FYPDB.findInstance(), projID);
		}
	}

	private void deregisterProject(){
		
		// View Projects
		if((new ViewPersonalProjects(this)).count!=0){
			System.out.println("Select Project to deregister:");
			int projID = super.sc.nextInt();

			FYPCoordinatorDB FYPDB = new FYPCoordinatorDB();

			new NewRequest(RequestType.DEREGISTERPROJECT, this, FYPDB.findInstance(), projID);
			reload = true;
		}
	}

	private void changeTitle(){
		
		// View Projects
		if((new ViewPersonalProjects(this)).count!=0){
			System.out.println("Select Assigned Project to change title:");
			int projID = super.sc.nextInt();

			new NewRequest(RequestType.CHANGETITLE, this, projDB.findInstance(projID).getSupervisor(), projID);
			reload = true;
		}
	}

	private void viewAllRequests(){
		new ViewOutgoingRequestsHistory(this);
	}
}