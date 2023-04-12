package Projects.ProjectClasses;

import Database.StudentDB;
import Projects.ModifyProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Users.Supervisor;

public class ChangeProjectSupervisor extends ModifyProjectDB{

    private int projID;
    private Supervisor supervisor;
    
    public ChangeProjectSupervisor(int projID, Supervisor sup){
        this.projID = projID;
        this.supervisor = sup;
        initializeFiles();
        updateDB();
        exportDB();
    }
    
    @Override
	public void updateDB() {		
        projDB.findInstance(projID).setSupervisor(supervisor);
        System.out.printf("Successfully changed supervisor to %s\n", supervisor.getName());
	}
}
