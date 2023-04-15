package Controller.Project.ModifyProjectController.ControllerObject;

import Controller.Project.ModifyProjectController.ModifyProjectController;
import Entity.DatabaseClass.SupervisorDB;
import Entity.UserClass.Supervisor;

public class ChangeProjectSupervisor extends ModifyProjectController{

    private int projID;
    private Supervisor supervisor;
    public SupervisorDB supDB;
    
    public ChangeProjectSupervisor(int projID, String supID){
        super();
        
        this.projID = projID;
        this.supervisor = supDB.findInstance(supID);

        updateDB();
        exportDB();
    }

    @Override
    public void loadFiles() {
        super.loadFiles();

        System.out.println("\nInitializing SupervisorDB...");
        this.supDB = new SupervisorDB();
        System.out.println("SupervisorDB Initialized.\n");
    }
    
    @Override
	public void updateDB() {		
        supDB = new SupervisorDB();
        supDB.findInstance(projDB.findInstance(projID).getSupervisor().getUserID()).removeAssignedProjects();
        supDB.findInstance(supervisor.getUserID()).addAssignedProjects();
        supDB.exportDB();
        projDB.findInstance(projID).setSupervisor(supervisor);

        System.out.printf("Successfully changed supervisor to %s\n", supervisor.getName());
	}
}
