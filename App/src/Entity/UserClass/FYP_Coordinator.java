package Entity.UserClass;

import Exceptions.InvalidInputException;
import Controller.Project.ViewProjectController.*;
import Controller.Request.ViewRequestController.ControllerObject.ViewAllRequestsHistory;
import Controller.Request.ViewRequestController.ControllerObject.ViewPendingRequests;
import Entity.UserClass.UserDetails.*;;

public class FYP_Coordinator extends Supervisor {

	public FYP_Coordinator() {}

	/**
	 * FYP Coordinator constructor.
	 * 
	 * @param userID Unique ID of the FYP coordinator.
	 * @param name Name of the FYP coordinator.
	 * @param email Email address of the FYP coordinator.
	 */
	public FYP_Coordinator(String userID, String name, String email) {
		super(userID, name, email, 0);
		super.setUserType(UserType.FYPCOORDINATOR);
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
		int choice = -1;

		loadFiles();
		reload = false;

		while (choice != 0){	
			
			// Show User Menu
			viewUserMenu();

			// Get Input 
			System.out.println("\nEnter your option: ");
			choice = super.sc.nextInt();

			switch(choice){
				case 1: 
					System.out.println("Option [1] selected! - View All Requests");
					new ViewAllRequestsHistory(this);
					break;

				case 2: 
					System.out.println("Option [2] selected! - Manage Requests.");
					new ViewPendingRequests(this);
					// manageRequests();
					break;

				case 3:
					System.out.println("Option [3] selected! - View Pending Requests.");
					new ViewPendingRequests(this);
					break;

				case 4:	
					System.out.println("Option [4] selected! - View Projects.");
					viewProjectOption();
					break;

				case 5: 
					System.out.println("Option [5] selected! - Generate Project Report."); 
				
			
				case 0: 
					System.out.println("Option [0] selected! - Exit Program");
					break;

				default:
					throw new InvalidInputException(choice);
			}
		}
	}

	private void viewProjectOption(){
		System.out.println("[1] View Personal Projects");
		System.out.println("[2] View All Projects");
		System.out.println("[0] Exit");

		switch(sc.nextInt()){
			case 1:
				new ViewPersonalProjects(this);
				break;
			case 2:
				new ViewAvailableProjects(this);
				break;
			case 0:
				break;
		}
	}

	// @Override
	// public void manageRequests() {

	// 	//manage requests
	// 	System.out.println("Enter RequestID to Approve/Reject: ");
	// 	int reqID = sc.nextInt();

	// 	Request currentReq = reqDB.findInstance(reqID);

	// 	System.out.println("Approve/ Reject");
	// 	System.out.println("[1] Approve");
	// 	System.out.println("[0] Reject");
	// 	int choice = sc.nextInt();

	// 	// currentReq.enactRequest(choice);

	// 	reqDB.exportDB();

	// }
}