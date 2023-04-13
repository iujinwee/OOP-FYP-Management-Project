package Entity.UserClass;

import Exceptions.InvalidInputException;

import java.util.InputMismatchException;

import Controller.Project.GenerateProjectReportController.GenerateReport;
import Controller.Project.ViewProjectController.*;
import Controller.Request.ManageRequestController.ManageRequest;
import Controller.Request.ViewRequestController.ControllerObject.ViewAllRequestsHistory;
import Controller.Request.ViewRequestController.ControllerObject.ViewPendingRequests;
import Entity.UserClass.UserDetails.*;

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
		System.out.println("\n=============  MENU  ==============");
		System.out.println("[1] View All Requests.");
		System.out.println("[2] Manage Requests.");
		System.out.println("[3] View Pending Requests.");
		System.out.println("[4] View Projects.");
		System.out.println("[5] Generate Project Report.");
		System.out.println("[0] Exit Program.");
	}
	
	@Override
	public void getInput() throws InvalidInputException{
		
		// Account acc;
		// boolean loggedin = true;
		// loadFiles(reload);
		// reload = false;
		// int choice = -1;

		// while (choice != 0 && loggedin){	
		int choice = -1;

		while (choice != 0){	
			
			// Show User Menu
			viewUserMenu();

			// Get Input 
			System.out.printf("\nEnter Option: ");
			choice = sc.nextInt();

			switch(choice){
				case 1: 
					System.out.println("Option [1] selected! - View All Requests\n");
					new ViewAllRequestsHistory(this);
					break;

				case 2: 
					System.out.println("Option [2] selected! - Manage Requests.\n");
					new ManageRequest(this);

					break;

				case 3:
					System.out.println("Option [3] selected! - View Pending Requests.\n");
					new ViewPendingRequests(this);
					break;

				case 4:	
					System.out.println("Option [4] selected! - View Projects.\n");
					viewProjectOption();
					break;

				case 5: 
					System.out.println("Option [5] selected! - Generate Project Report.\n"); 
					new GenerateReport();
					break;
			
				case 0: 
					System.out.println("Option [0] selected! - Exit Program\n");
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
		System.out.printf("\nEnter Option: ");
		
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
}