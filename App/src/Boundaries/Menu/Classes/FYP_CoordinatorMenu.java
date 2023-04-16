package Boundaries.Menu.Classes;

import Boundaries.Project.ViewAvailableProjects;
import Boundaries.Project.ViewPersonalProjects;
import Boundaries.Request.Classes.ViewAllRequestsHistory;
import Boundaries.Request.Classes.ViewPendingRequests;
import Controller.Account.ModifyAccountDB.ChangePassword;
import Controller.Menu.CheckInputUserMenuInput;
import Controller.Project.GetInputModifyProject.ChangeProjectTitle;
import Controller.Project.GetInputModifyProject.CreateProject;
import Controller.Project.ModifyProject.ChangeProjectSupervisor;
import Controller.Request.ManageRequest.ManageRequest;
import Entity.UserClass.FYP_Coordinator;
import Exceptions.InvalidInputException;

public class FYP_CoordinatorMenu extends CheckInputUserMenuInput{
    
    private FYP_Coordinator fyp_coordinator;

	/**
	 * FYP Coordinator Menu Constructor.
	 * @param fyp_coordinator FYP Coordinator Object
	 */
    public FYP_CoordinatorMenu(FYP_Coordinator fyp_coordinator) {
        this.fyp_coordinator = fyp_coordinator;
		
		handleException();
    }

    
	@Override
    public void viewUserMenu() {
		System.out.println("\n=============  FYP COORDINATOR MENU  ==============");
		System.out.println("[1] View All Requests.");
		System.out.println("[2] Manage Requests.");
		System.out.println("[3] View Pending Requests.");
		System.out.println("[4] Create New Project.");
		System.out.println("[5] Change Title of Project");
		System.out.println("[6] Transfer Student to Replacement Supervisor");
		System.out.println("[7] View Projects.");
		System.out.println("[8] Generate Project Report.");
		System.out.println("[9] Change Password. ");
		System.out.println("[10] Logout.");
		System.out.println("[0] Exit Program.");
    }

    
	/** 
	 * @throws InvalidInputException
	 */
	@Override
    public void getInput() throws InvalidInputException {

		int choice = -1;
		while(choice != 0 && choice != 7) {
			viewUserMenu();

			System.out.printf("\nEnter option: ");
			choice = sc.nextInt();

		switch(choice){
			case 1: 
			System.out.println("\nOption [1] selected! - View All Requests.\n");
			new ViewAllRequestsHistory(fyp_coordinator);
			break;

			case 2: 
				System.out.println("\nOption [2] selected! - Manage Requests.\n");
				new ManageRequest(fyp_coordinator);
				break;

			case 3:
				System.out.println("\nOption [3] selected! - View Pending Requests.\n");
				new ViewPendingRequests(fyp_coordinator);
				break;

			case 4:
				System.out.println("\nOption [4] selected! - Create New Project.\n");
				new CreateProject(fyp_coordinator);
				break;

			case 5: 
				System.out.println("\nOption [5] selected! - Change Title of Project.\n");
				new ChangeProjectTitle(fyp_coordinator);
				break;

			case 6: 
				System.out.println("\nOption [6] selected! - Transfer Student to Replacement Supervisor.\n");
				new ChangeProjectSupervisor(fyp_coordinator);
				break;
			
			case 7:  
				System.out.println("\nOption [7] selected! - View Projects.\n");
				viewProjectOption();
				break;

			case 8: 
				System.out.println("\nOption [8] selected! - Generate Project Report.\n"); 
				new GenerateReportMenu(fyp_coordinator);
				break;

			case 9:
				System.out.println("\nOption [9] selected! - Change Password.\n");
				new ChangePassword(fyp_coordinator.getUserID());
				break;
			
			case 10:
				System.out.println("\nOption [10] selected! - Log Out.\n");
				new WelcomePage();
				break;
			
			case 0: 
				System.out.println("\nOption [0] selected! - Exit Program.\n");
				new WelcomePage();
				break;

			default:
				throw new InvalidInputException(choice);
		}
		}
    }
	
	/**
	 * Method to view different project options for FYP coordinator.
	 */
    private void viewProjectOption(){
		System.out.println("[1] View Personal Projects");
		System.out.println("[2] View All Projects");
		System.out.println("[0] Exit");
		System.out.printf("\nEnter Option: ");
		
		switch(sc.nextInt()){
			case 1:
				new ViewPersonalProjects(fyp_coordinator);
				break;
			case 2:
				new ViewAvailableProjects(fyp_coordinator);
				break;
			case 0:
				break;
		}
	}
}
