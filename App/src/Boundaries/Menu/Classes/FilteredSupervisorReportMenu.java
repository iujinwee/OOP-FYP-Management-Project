package Boundaries.Menu.Classes;

import Boundaries.Project.FilteredSupervisorReport;
import Controller.Menu.CheckInputFilteredReportMenu;
import Entity.DatabaseClass.SupervisorDB;
import Entity.UserClass.FYP_Coordinator;
import Entity.UserClass.Supervisor;
import Exceptions.InvalidInputException;

public class FilteredSupervisorReportMenu extends CheckInputFilteredReportMenu {

    private SupervisorDB supDB = new SupervisorDB();
    private Supervisor supervisor;
    private FYP_Coordinator coord;
    
    public FilteredSupervisorReportMenu(FYP_Coordinator coord) {
        this.coord = coord;
        handleException();
        new GenerateReportMenu(coord);
    }

    @Override
    public void viewUserMenu() {
		System.out.println("\nFilter Supervisor Report");
        System.out.println("=================================\n");

    }

    /** 
     * @throws InvalidInputException
     */
    @Override
    public void getInput() throws InvalidInputException {
        
        viewUserMenu();

        supDB.view();
        
        // Show error
        if(handler.getAttempts()!=0){
            handler.printWarning();
        }

        System.out.printf("\nEnter Supervisor ID to filter (Enter 'back' to exit): ");
        String supID = sc.next();
        supervisor = supDB.findInstance(supID);

        if (supID.compareTo("back")==0){
            System.out.println();
            new GenerateReportMenu(coord);
        }else if((supervisor == null) || (supervisor.getName() == null)){
            throw new InvalidInputException(supID);
        }else{
            new FilteredSupervisorReport(supervisor);
        }

    }

}
