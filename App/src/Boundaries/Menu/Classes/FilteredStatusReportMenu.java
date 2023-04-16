package Boundaries.Menu.Classes;

import Boundaries.Project.FilteredStatusReport;
import Controller.Menu.CheckInputFilteredReportMenu;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.FYP_Coordinator;
import Exceptions.InvalidInputException;

public class FilteredStatusReportMenu extends CheckInputFilteredReportMenu {

    /**
	 * Filtered Status Report Menu Constructor.
	 * @param coord FYP Coordinator Object
	 */
    public FilteredStatusReportMenu(FYP_Coordinator coord) {
        handleException();
        new GenerateReportMenu(coord);
    }

    @Override
    public void viewUserMenu() {
		System.out.println("\nFilter Status Report");
        System.out.println("=================================\n");
        System.out.println("[1] Allocated");
        System.out.println("[2] Reserved");
        System.out.println("[3] Available");
        System.out.println("[4] Unavailable");
        System.out.println("[0] Back");
    }

    /** 
     * @throws InvalidInputException
     */
    @Override
    public void getInput() throws InvalidInputException {
        
        viewUserMenu();

        System.out.printf("\nEnter Project Status to filter: ");
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                new FilteredStatusReport(ProjectStatus.ALLOCATED);
                break;
        
            case 2: 
                new FilteredStatusReport(ProjectStatus.RESERVED);
                break;

            case 3: 
                new FilteredStatusReport(ProjectStatus.AVAILABLE);
                break;

            case 4: 
                new FilteredStatusReport(ProjectStatus.UNAVAILABLE);
                break;

            case 0: 
                break;

            default:
                throw new InvalidInputException(choice);
        }
    }

}
