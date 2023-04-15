package Controller.User.UserMenuController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.Account.AccessAccountDBController.ChangePassword;
import Entity.UserClass.FYP_Coordinator;
import Exceptions.handleInvalidInput;
import Exceptions.InvalidInputException;

public class FYP_CoordinatorMenu extends UserMenuController{
    
    private FYP_Coordinator fyp_coordinator;
    private handleInvalidInput handler = new handleInvalidInput(3);

    public FYP_CoordinatorMenu(FYP_Coordinator fyp_coordinator) {
        this.fyp_coordinator = fyp_coordinator;

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
        Scanner sc = new Scanner(System.in);

        int choice = -1;
        while(choice != 0) {
            viewUserMenu();

            System.out.printf("\nEnter option: ");
            choice = sc.nextInt();

            switch(choice) {
				case 1: 
					System.out.println("Option [1] selected! - View All Requests\n");
					break;

				case 2: 
					System.out.println("Option [2] selected! - Manage Requests.\n");
					break;

				case 3:
					System.out.println("Option [3] selected! - View Pending Requests.\n");
					break;

				case 4:	
					System.out.println("Option [4] selected! - View Projects.\n");
					break;

				case 5: 
					System.out.println("Option [5] selected! - Generate Project Report.\n"); 
					break;
                
                case 6:
                    System.out.println("\nOption [6] selected! - Change Password");
                    System.out.println("Enter new password: ");
                    String newPassword = sc.next();
                    new ChangePassword(fyp_coordinator.getUserID(), newPassword);
                    break;
			
				case 0: 
					System.out.println("Option [0] selected! - Exit Program\n");
					break;

				default:
					throw new InvalidInputException(choice);
			}
		}
        sc.close();
    }
}
