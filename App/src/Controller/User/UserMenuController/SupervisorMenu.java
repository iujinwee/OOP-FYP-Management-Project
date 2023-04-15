package Controller.User.UserMenuController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.Account.ModifyAccountDBController.ChangePassword;
import Controller.Project.ModifyProjectController.ControllerObject.ChangeProjectTitle;
import Controller.Project.ModifyProjectController.ControllerObject.CreateProject;
import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Controller.Request.CreateRequestController.ControllerObject.NewChangeSupervisorRequest;
import Controller.Request.ManageRequestController.RequestManager;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewIncomingRequestsHistory;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewOutgoingRequestsHistory;
import Entity.UserClass.Supervisor;
import Exceptions.handleInvalidInput;
import Exceptions.InvalidInputException;

public class SupervisorMenu extends UserMenuController {

    private Supervisor supervisor;
    private handleInvalidInput handler = new handleInvalidInput(3);
	Scanner sc = new Scanner(System.in);

    public SupervisorMenu(Supervisor supervisor) {
        this.supervisor = supervisor;

        while(handler.checkAttempts()) {
            try {    
                getInput();
                break;
    
            }catch(InputMismatchException e){
                handler.handleInputMismatchException(e);
            }catch(InvalidInputException e){
                handler.handleInvalidInputException(e);
            }
        } 
    }

    @Override
    public void viewUserMenu() {
        System.out.println("=============  SUPERVISOR MENU  ==============");
		System.out.println("[1] Create New Project");
		System.out.println("[2] View Projects created by me");
		System.out.println("[3] Change Title of Project");
		System.out.println("[4] Request to Transfer Student to Replacement Supervisor");
		System.out.println("[5] Manage Incoming Requests ");
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
					System.out.println("Option [1] selected! - Create New Project.");
					new CreateProject(supervisor);
					break;

				case 2: 
					//Supervisor views his/her projects
					System.out.println("Option [2] selected! - View Projects created by me.");
					new ViewPersonalProjects(supervisor);
					break;

				case 3:
					//Supervisor changes title of his/her projects
					System.out.println("Option [3] selected! - Change Title of Project.");
					changeProjectTitle();
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
					System.out.println("Option [6] selected! - View all incoming and outgoing requests.");
					new ViewIncomingRequestsHistory(supervisor);
					new ViewOutgoingRequestsHistory(supervisor);
					break;

				case 7:
					System.out.println("\nOption [7] selected! - Change Password");
                    new ChangePassword(supervisor.getUserID());
					break;

				case 0: 
					System.out.println("Option [0] selected! - Exit Program");
					break;

				default:
					throw new InvalidInputException(choice);
			}
        }
        sc.close();
    }

	private void changeProjectTitle() throws InvalidInputException{
		// View Projects
		ViewPersonalProjects projs = new ViewPersonalProjects(supervisor);

		System.out.println("Select Project ID to change new title:");
		int projID = sc.nextInt();

		boolean own = projs.projects.contains(projID);
		if(own){	
			System.out.println("Enter the new title:");
			String newTitle = sc.next();
			new ChangeProjectTitle(projID, newTitle);

		}else{
			throw new InvalidInputException(projID);
		}
	}
}


