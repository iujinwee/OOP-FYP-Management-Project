package Controller.User.UserMenuController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.Account.AccessAccountDBController.ChangePassword;
import Entity.UserClass.Supervisor;
import Exceptions.handleInvalidInput;
import Exceptions.InvalidInputException;

public class SupervisorMenu extends UserMenuController {

    private Supervisor supervisor;
    private handleInvalidInput handler = new handleInvalidInput(3);
    
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
        Scanner sc = new Scanner(System.in);

        int choice = -1;
        while(choice != 0) {
            viewUserMenu();

            System.out.printf("\nEnter option: ");
            choice = sc.nextInt();

            switch(choice){
				case 1: 
					System.out.println("Option [1] selected! - Create New Project.");
					break;

				case 2: 
					//Supervisor views his/her projects
					System.out.println("Option [2] selected! - View Projects created by me.");
					break;

				case 3:
					//Supervisor changes title of his/her projects
					System.out.println("Option [3] selected! - Change Title of Project.");
					break;

				case 4:	
					System.out.println("Option [4] selected! - Request to Transfer Student to Replacement Supervisor.");
					break;
					
				case 5:
					System.out.println("Option [5] selected! - Manage Incoming Requests.");
					break;

				case 6:
					System.out.println("\nOption [6] selected! - Change Password");
					System.out.println("Enter new password: ");
                    String newPassword = sc.next();
                    new ChangePassword(supervisor.getUserID(), newPassword);
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
}


