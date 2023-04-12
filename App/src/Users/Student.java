package Users;

import Exceptions.InvalidInputException;
import Login.Account;
import Projects.Project;
import Users.UserDetails.*;
import Requests.RequestType;

public class Student extends User{

	private int choice = -1;
 	
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

		int projID;
		Account acc;
		boolean loggedin = true;
		loadFiles(reload);
		reload = false;

		while (choice != 0 && loggedin){	

			// Show User Menu
			viewUserMenu();

			// Get Input 
			System.out.println("\nEnter your option: ");
			choice = super.sc.nextInt();

			switch(choice){
				case 1: 
					System.out.println("\nOption [1] selected! - Show Available Projects");
					projDB.viewProjects(this);
					break;

				case 2: 
					System.out.println("\nOption [2] selected! - Show Registered Project.");
					projDB.viewPersonalProjects(this);
					break;

				case 3:
					System.out.println("\nOption [3] selected! - Register Project.");

					// View Projects
					projDB.viewProjects(this);
					System.out.println("Select Project to register:");
					projID = super.sc.nextInt();
					
					reqDB.createRequest(RequestType.REGISTERPROJECT, this, ((Project) projDB.findInstance(projID)).getSupervisor(), projID);
					reload = true;
					break;

				case 4:	
					System.out.println("\nOption [4] selected! - Deregister Project.");
					
					// View Projects
					projDB.viewPersonalProjects(this);
					System.out.println("Select Project to deregister:");
					projID = super.sc.nextInt();
					projDB.findInstance(projID);

					reqDB.createRequest(RequestType.DEREGISTERPROJECT, this, ((Project)projDB.currentInstance).getSupervisor(), projID);
					reload = true;
					break;

				case 5:
					System.out.println("\nOption [5] selected! - Change Assigned Project Title.");

					// View Projects
					projDB.viewPersonalProjects(this);
					System.out.println("Select Assigned Project to change title:");
					projID = super.sc.nextInt();
					projDB.findInstance(projID);

					reqDB.createRequest(RequestType.CHANGETITLE, this, ((Project)projDB.currentInstance).getSupervisor(), projID);
					reload = true;
					break;

				case 6: 
					System.out.println("\nOption [6] selected! - View All Requests");
					reqDB.viewAllRequests(this);
					break;
				
				case 7:
					System.out.println("\nOption [7] selected! - Change Password");
					acc = accDB.findInstance(this.getUserID());
					acc.changePassword(accDB);
					loggedin = acc.login(accDB);
					break;

				case 0: 
					System.out.println("Option [0] selected! - Exit Program");
					break;

				default:
					throw new InvalidInputException(choice);
			}
		}
	}	
}