package Boundaries.Menu.Classes;

import Boundaries.Project.StatusReport;
import Boundaries.Project.SupervisorReport;
import Controller.Menu.CheckInputGenerateReportMenu;
import Entity.UserClass.FYP_Coordinator;
import Exceptions.InvalidInputException;

public class GenerateReportMenu extends CheckInputGenerateReportMenu {

    private FYP_Coordinator coord;
    public GenerateReportMenu(FYP_Coordinator fyp_Coordinator) {
        this.coord = fyp_Coordinator;
        handleException();
        new FYP_CoordinatorMenu(fyp_Coordinator);
    }

    @Override
    public void viewUserMenu() {
		System.out.println("Generate Project Report");
        System.out.println("=================================");
		System.out.println("[1] Get Status Report");
		System.out.println("[2] Get Supervisor Report");
        System.out.println("[3] Search Report Database (Status)");
        System.out.println("[4] Search Report Database (Supervisor)");
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
                System.out.println("\nOption [1] selected! - Get Status Report\n");
                new StatusReport();
                break;

            case 2:
                System.out.println("\nOption [2] selected! - Get Supervisor Report\n");   
                new SupervisorReport();
                break;

            case 3: 
                System.out.println("\nOption [3] selected! - Search Report Database (Status)\n");
                new FilteredStatusReportMenu(coord);
                break;

            case 4: 
                System.err.println("\nOption [4] selected! - Search Report Database (Supervisor)\n");
                new FilteredSupervisorReportMenu(coord);
                break;

            case 0:
                break;

            default: 
                throw new InvalidInputException(choice);
        }
    }
}
