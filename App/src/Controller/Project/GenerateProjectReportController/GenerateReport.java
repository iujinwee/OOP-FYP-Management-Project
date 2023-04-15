package Controller.Project.GenerateProjectReportController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.Interfaces.GetInputInterface;
import Boundaries.Menu.Interfaces.ViewUserMenuInterface;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public class GenerateReport implements ViewUserMenuInterface, GetInputInterface {
    
    private handleInvalidInput handler = new handleInvalidInput();

    public GenerateReport(){
        viewUserMenu();

        try {
            getInput();
        } catch(InputMismatchException e) {
            handler.handleInputMismatchException(e);
        } catch(InvalidInputException e) {
            handler.handleInvalidInputException(e);
        }
    }

    @Override
    public void viewUserMenu() {
		System.out.println("Generate Report (Search Filters)");
        System.out.println("=================================");
		System.out.println("[1] By Status");
		System.out.println("[2] By Supervisor");
        System.out.println("[0] Back");
    }

    
    /** 
     * @throws InvalidInputException
     */
    @Override
    public void getInput() throws InvalidInputException {
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("\nEnter option: ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                System.out.println("Generating Project Report by Status...");
                new StatusReport();
                break;

            case 2:
                System.out.println("Generating Project Report by Supervisor...");   
                new SupervisorReport();
                break;

            case 0:
                break;

            default: 
                throw new InvalidInputException(choice);
        }
    }
}
