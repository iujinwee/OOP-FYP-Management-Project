package Controller.User.UserMenuController;

import Controller.Account.ModifyAccountDBController.ChangePassword;
import Controller.Project.GenerateProjectReportController.GenerateReport;
import Controller.Project.ViewProjectController.ControllerObject.ViewAvailableProjects;
import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Controller.Request.ManageRequestController.RequestManager;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewAllRequestsHistory;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewPendingRequests;
import Entity.UserClass.FYP_Coordinator;
import Exceptions.InvalidInputException;

public class FYP_CoordinatorMenu extends UserMenuController{
    
    private FYP_Coordinator fyp_coordinator;

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
		System.out.println("[4] View Projects.");
		System.out.println("[5] Generate Project Report.");
        System.out.println("[6] Change Password ");
		System.out.println("[0] Exit Program.");
    }

    @Override
    public void getInput() throws InvalidInputException {

        int choice = -1;
        while(choice != 0) {
            viewUserMenu();

            System.out.printf("\nEnter option: ");
            choice = sc.nextInt();

            switch(choice){
				case 1: 
					System.out.println("Option [1] selected! - View All Requests\n");
					new ViewAllRequestsHistory(fyp_coordinator);
					break;

				case 2: 
					System.out.println("Option [2] selected! - Manage Requests.\n");
					new RequestManager(fyp_coordinator);

					break;

				case 3:
					System.out.println("Option [3] selected! - View Pending Requests.\n");
					new ViewPendingRequests(fyp_coordinator);
					break;

				case 4:	
					System.out.println("Option [4] selected! - View Projects.\n");
					viewProjectOption();
					break;

				case 5: 
					System.out.println("Option [5] selected! - Generate Project Report.\n"); 
					new GenerateReport();
					break;

                case 6:
                    System.out.println("\nOption [6] selected! - Change Password");
                    new ChangePassword(fyp_coordinator.getUserID());
                    break;
			
				case 0: 
					System.out.println("\nOption [0] selected! - Exit Program\n");
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
