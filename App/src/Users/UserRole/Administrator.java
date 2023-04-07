package Users.UserRole;

import java.util.Scanner;

import Projects.ProjectDB;
import Requests.RequestDB;
import Users.UserDetails.User;

public class Administrator extends User implements ManageRequestMenu {

	/**
	 * 
	 * @param RequestDB
	 */

	private RequestDB reqDB;
	private ProjectDB projDB; 
	
	public Administrator(String userID, String name, String email){
		
		// Call Constructor
		super(userID, name, email);

		// Initialize DB 
		reqDB = new RequestDB();
		projDB = new ProjectDB();
	}

	public void manageRequests() {
		// View all Requests (To include in sub-class)
		// reqDB.viewAllRequest(); 

		Scanner sc = new Scanner(System.in);
		System.out.println("Select Request:");


		int requestId = sc.nextInt();
		reqDB.viewRequest(requestId);

		int choice = sc.nextInt();
		switch (choice) {
			// Approve
			case 1:
				
				break;
		
			// Reject 
			case 2: 	
			default:
				break;
		}
	}

	public isBoolean createProject() {
		projDB.createProject();
	}

	public isBoolean changeTitle() {
		projDB.setProjectTitle();
	}

	@Override
	public void viewUserMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approve() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reject() {
		// TODO Auto-generated method stub
		
	}
}