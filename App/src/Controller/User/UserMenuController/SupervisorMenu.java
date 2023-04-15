package Controller.User.UserMenuController;

import Controller.Account.ModifyAccountDBController.ChangePassword;
import Controller.Project.ModifyProjectController.ControllerObject.ChangeProjectTitle;
import Controller.Project.ModifyProjectController.ControllerObject.CreateProject;
import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Controller.Request.CreateRequestController.ControllerObject.NewChangeSupervisorRequest;
import Controller.Request.ManageRequestController.RequestManager;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewIncomingRequestsHistory;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewOutgoingRequestsHistory;
import Entity.UserClass.Supervisor;
import Exceptions.InvalidInputException;

public class SupervisorMenu extends UserMenuController {

    private Supervisor supervisor;

    public SupervisorMenu(Supervisor supervisor) {
		this.supervisor = supervisor;

		handleException();
    }

    @Override
    public void viewUserMenu() {
        System.out.println("=============  SUPERVISOR MENU  ==============");
		System.out.println("[1] Create New Project");
		System.out.println("[2] View Projects Created By Me");
		System.out.println("[3] Change Title of Project");
		System.out.println("[4] Request to Transfer Student to Replacement Supervisor");
		System.out.println("[5] Manage Incoming Requests ");
		System.out.println("[6] View Request Status and History ");
		System.out.println("[7] Change Password ");
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
					System.out.println("Option [1] selected! - Create New Project.");
					new CreateProject(supervisor);
					break;

				case 2: 
					//Supervisor views his/her projects
					System.out.println("Option [2] selected! - View Projects Created By Me.");
					new ViewPersonalProjects(supervisor);
					break;

				case 3:
					//Supervisor changes title of his/her projects
					System.out.println("Option [3] selected! - Change Title of Project.");
					new ChangeProjectTitle(supervisor);
					break;

				case 4:	
					System.out.println("Option [4] selected! - Request to Transfer Student to Replacement Supervisor.");
					new NewChangeSupervisorRequest(supervisor);
					break;
					
				case 5:
					System.out.println("Option [5] selected! - Manage Incoming Requests.");
					new RequestManager(supervisor);
					break;

				case 6:
					System.out.println("Option [6] selected! - View All Incoming and Outgoing Requests.");
					new ViewIncomingRequestsHistory(supervisor);
					new ViewOutgoingRequestsHistory(supervisor);
					break;

				case 7:
					System.out.println("\nOption [7] selected! - Change Password");
                    new ChangePassword(supervisor.getUserID());
					break;

				case 0: 
					System.out.println("\nOption [0] selected! - Exit Program");
					break;

				default:
					throw new InvalidInputException(choice);
			}
        }
    }
}


