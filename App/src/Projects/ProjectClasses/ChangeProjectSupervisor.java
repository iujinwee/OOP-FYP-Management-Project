package Projects.ProjectClasses;

import Database.StudentDB;
import Database.SupervisorDB;
import Projects.ModifyProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Users.Supervisor;

public class ChangeProjectSupervisor extends ModifyProjectDB{

    private int projID;
    private Supervisor supervisor;
    public SupervisorDB supDB;
    
    public ChangeProjectSupervisor(int projID, String supID){
        initializeFiles();
        
        this.projID = projID;
        this.supervisor = supDB.findInstance(supID);

        updateDB();
        exportDB();
    }

    @Override
    public void initializeFiles() {
        super.initializeFiles();

        System.out.println("\nInitializing SupervisorDB...");
        this.supDB = new SupervisorDB();
        System.out.println("SupervisorDB Initialized.\n");
    }
    
    @Override
	public void updateDB() {		

        projDB.findInstance(projID).setSupervisor(supervisor);
        System.out.printf("Successfully changed supervisor to %s\n", supervisor.getName());
	}
}
