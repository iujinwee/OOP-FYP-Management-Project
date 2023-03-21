package Users;
import java.util.*;

import Projects.ProjectDB;
import Requests.RequestDetails.Request;
import Requests.RequestDetails.RequestType;
import Users.UserDetails.UserType;
import Users.UserRole.Requestor;
import Requests.RequestDB;

public class Student extends Requestor{

	ArrayList<Request> sends;
	// Project registeredTo;
	private String studentID;
	private ProjectDB projDB;

	/**
	 * 
	 * @param userID
	 * @param name
	 */
	public Student(String userID, String name, String email) {

		// Initialization
		super(userID, name, email);
		super.setUserType(UserType.STUDENT);
		this.studentID = getUserID();

		// Load Database
		projDB = new ProjectDB();

		// Get User Input  
		Scanner sc = new Scanner(System.in);
		int choice = -1;

		try{
			while (choice != 0){
				// Show User Menu 
				viewUserMenu();
			
				// Get Input 
				System.out.println("\nEnter your option: ");
				
				// Exception for invalid input 

				switch(choice){
					case 1: 
						projDB.viewProjects(UserType.STUDENT);
						break;
					case 2: 
						viewRegisteredProject();
						break;
					case 3:
						sendRequest(RequestType.REGISTERPROJECT);
						break;
					case 4:
						sendRequest(RequestType.DEREGISTERPROJECT);
						break;
					case 5:
						sendRequest(RequestType.CHANGETITLE);
						break;

					default:
						System.out.println("Terminating Program...");
						break;	
				}
			}
		}catch(Exception e){
			// Exception Handler
		}

	}

	@Override
	public void viewUserMenu() {
		System.out.println("=============  MENU  ==============");
		System.out.println("[1] Show Available Projects.");
		System.out.println("[2] Show Registered Project.");
		System.out.println("[3] Register Project.");
		System.out.println("[4] Deregister Project.");
		System.out.println("[5] Change Assigned Project Title.");
		System.out.println("[0] Exit Program.");
	}
	
	public void viewRegisteredProject() {
		// TODO - implement Student.viewRegisteredProject
	}

}