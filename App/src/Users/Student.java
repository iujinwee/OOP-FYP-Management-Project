package Users;
import java.util.*;

import Database.ProjectDB;
import Database.RequestDB;
import Exceptions.InvalidInputException;
import Users.UserDetails.*;
import Requests.*;

public class Student extends User{

	ArrayList<Request> sends;
	private int choice = -1;
	private ProjectDB projDB;
	private RequestDB reqDB;
 	
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
		super.setType(UserType.STUDENT);
		this.studentID = super.getUserID();
	}

	public String getStudentID() {
		return this.studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public void viewRegisteredProject() {

	}

	public void viewUserMenu() {
		System.out.println("=============  MENU  ==============");
		System.out.println("[1] Show Available Projects.");
		System.out.println("[2] Show Registered Project.");
		System.out.println("[3] Register Project.");
		System.out.println("[4] Deregister Project.");
		System.out.println("[5] Change Assigned Project Title.");
		System.out.println("[6] View All Requests.");
		System.out.println("[0] Exit Program.");
	}

	@Override
	public void getInput() throws InvalidInputException{

		while (choice != 0){	
			
			// Load DB 
			ProjectDB projDB = new ProjectDB();
			RequestDB reqDB = new RequestDB();

			// Show User Menu
			viewUserMenu();

			// Get Input 
			System.out.println("\nEnter your option: ");
			choice = super.getScanner().nextInt();

			switch(choice){
				case 1: 
					System.out.println("Option [1] selected! - Show Available Projects");

					projDB.viewAvailableProjects();
					break;
				case 2: 
					System.out.println("Option [2] selected! - Show Registered Project.");
					projDB.viewRegisteredProjects(super.getUserID());

					break;
				case 3:
					System.out.println("Option [3] selected! - Register Project.");
					reqDB.createRequest(RequestType.REGISTERPROJECT);
					break;
				case 4:	
					System.out.println("Option [4] selected! - Deregister Project.");
					reqDB.createRequest(RequestType.DEREGISTERPROJECT);
					break;
				case 5:
					System.out.println("Option [5] selected! - Change Assigned Project Title.");
					reqDB.createRequest(RequestType.CHANGETITLE);
					break;

				case 6: 
					System.out.println("Option [6] selected! - View All Requests");
					reqDB.viewAllRequests(super.getUserID());
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