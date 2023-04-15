package Boundaries.Menu.Classes;

import Boundaries.Project.StatusReport;
import Boundaries.Project.SupervisorReport;
import Controller.Menu.CheckInputGenerateReportMenu;
import Exceptions.InvalidInputException;

public class GenerateReportMenu extends CheckInputGenerateReportMenu {

    public GenerateReportMenu() {
        handleException();
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
        
        viewUserMenu();

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
