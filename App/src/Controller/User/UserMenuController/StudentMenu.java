package Controller.User.UserMenuController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.Account.AccessAccountDBController.ChangePassword;
import Entity.UserClass.Student;
import Exceptions.handleInvalidInput;
import Exceptions.InvalidInputException;


public class StudentMenu extends UserMenuController {
    
    private Student student;
    private handleInvalidInput handler = new handleInvalidInput(3);

    public StudentMenu(Student student) {
        this.student = student;

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
        System.out.println("=============  STUDENT MENU  ==============");
		System.out.println("[1] Show Available Projects.");
		System.out.println("[2] Show Registered Project.");
		System.out.println("[3] Register Project.");
		System.out.println("[4] Deregister Project.");
		System.out.println("[5] Change Assigned Project Title.");
		System.out.println("[6] View All Requests.");
		System.out.println("[7] Change Password.");
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
					System.out.println("\nOption [1] selected! - Show Available Projects");
					break;

				case 2: 
					System.out.println("\nOption [2] selected! - Show Registered Project.");
					break;

				case 3:
					System.out.println("\nOption [3] selected! - Register Project.");
					break;

				case 4:	
					System.out.println("\nOption [4] selected! - Deregister Project.");
					break;

				case 5:
					System.out.println("\nOption [5] selected! - Change Assigned Project Title.");
					break;

				case 6: 
					System.out.println("\nOption [6] selected! - View All Requests");
					break;
                    
                case 7:
                    System.out.println("\nOption [7] selected! - Change Password");
                    System.out.println("Enter new password: ");
                    String newPassword = sc.next();
                    new ChangePassword(student.getUserID(), newPassword);
            
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
