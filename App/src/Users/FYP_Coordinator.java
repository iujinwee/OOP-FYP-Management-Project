package Users;

import java.util.*;

import Exceptions.InvalidInputException;
import Projects.ProjectDB;	//to change 
import Requests.Request;
import Requests.RequestDB;	//to change 
import Users.UserDetails.UserType;
import Requests.Request;

public class FYP_Coordinator extends Supervisor {

	private int choice = -1;
	private String CoordinatorID;
	private ProjectDB projDB;
	private RequestDB reqDB;
	Scanner sc= new Scanner (System.in);

	public FYP_Coordinator() {}

	/**
	 * FYP Coordinator constructor.
	 * 
	 * @param userID Unique ID of the FYP coordinator.
	 * @param name Name of the FYP coordinator.
	 * @param email Email address of the FYP coordinator.
	 */
	public FYP_Coordinator(String userID, String name, String email) {
		super(userID, name, email);
		// super.setType(UserType.FYPCOORDINATOR);
	}

	public void viewUserMenu() {
		System.out.println("=============  MENU  ==============");
		System.out.println("[1] View All Requests.");
		System.out.println("[2] Manage Requests.");
		System.out.println("[3] View Pending Requests.");
		System.out.println("[4] View Projects.");
		System.out.println("[0] Exit Program.");
	}
	
	@Override
	public void getInput() throws InvalidInputException{

		while (choice != 0){	
			
			// Show User Menu
			viewUserMenu();

			// Get Input 
			System.out.println("\nEnter your option: ");
			choice = super.getScanner().nextInt();

			switch(choice){
				case 1: 
					System.out.println("Option [1] selected! - View All Requests");
					reqDB.viewAllRequests(this);
					break;
				case 2: 
					System.out.println("Option [2] selected! - Manage Requests.");
					reqDB.viewPendingRequests(this);
					manageRequests();
					break;
				case 3:
					System.out.println("Option [3] selected! - View Pending Requests.");
					reqDB.viewPendingRequests(this);
					break;
				case 4:	
					System.out.println("Option [4] selected! - View Projects.");
					//in projectDB - will ask to view all or only view 
					projDB.viewProjects(this);
					break;
			
				case 0: 
					System.out.println("Option [0] selected! - Exit Program");
					break;

				default:
					throw new InvalidInputException(choice);
			}
		}
	}

	@Override
	public void manageRequests() {

		//manage requests
		System.out.println("Enter RequestID to Approve/Reject: ");
		int reqID = sc.nextInt();

		Request currentReq = reqDB.findInstance(reqID);

		System.out.println("Approve/ Reject");
		System.out.println("[1] Approve");
		System.out.println("[0] Reject");
		int choice = sc.nextInt();

		currentReq.enactRequest(choice);

		reqDB.exportDB();

	}
	}