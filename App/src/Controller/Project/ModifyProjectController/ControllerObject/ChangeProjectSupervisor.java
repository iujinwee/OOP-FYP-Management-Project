package Controller.Project.ModifyProjectController.ControllerObject;

import Controller.Project.ModifyProjectController.ModifyProjectController;
import Entity.DatabaseClass.SupervisorDB;
import Entity.DatabaseClass.ProjectDB;
import Entity.UserClass.Supervisor;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;

public class ChangeProjectSupervisor extends ModifyProjectController {

    private int projID;
    private Supervisor supervisor;
    public SupervisorDB supDB;
    public ProjectDB projDB;
    
    public ChangeProjectSupervisor(int projID, String supID){
        super();
        
        SupervisorDB supDB = new SupervisorDB();
        this.projID = projID;
        this.supervisor = supDB.findInstance(supID);

        updateDB();
        exportDB();
    }
    
    @Override
	public void updateDB() {		
        projDB = new ProjectDB();
        supDB = new SupervisorDB();
        supDB.findInstance(projDB.findInstance(projID).getSupervisor().getUserID()).removeAssignedProjects();
        // if(supDB.findInstance(projDB.findInstance(projID).getSupervisor().getUserID()).getNumAssignedProjects() < 2){
        //     for (Object obj : projDB.objectDB) {
        //         Project curProject = (Project) obj;
        //         if (supDB.findInstance(supervisor.getUserID()).getUserID().compareTo(curProject.getSupervisorID())==0 && curProject.getProjectStatus() == ProjectStatus.UNAVAILABLE) {
        //             curProject.setProjectStatus(ProjectStatus.AVAILABLE); // TO CHANGE
        //         }
        //     }
        // }
        supDB.findInstance(supervisor.getUserID()).addAssignedProjects();
        projDB.findInstance(projID).setSupervisor(supervisor);
        // if(supervisor.getNumAssignedProjects() == 2){
        //     for (Object obj : projDB.objectDB) {
        //         Project curProject = (Project) obj;
        //         if (supDB.findInstance(supervisor.getUserID()).getUserID().compareTo(curProject.getSupervisorID())==0 && curProject.getProjectStatus() == ProjectStatus.AVAILABLE) {
        //             curProject.setProjectStatus(ProjectStatus.UNAVAILABLE); // TO CHANGE
        //         }
        //     }
        // }
        supDB.exportDB();
        

        System.out.printf("Successfully changed supervisor to %s\n", supervisor.getName());
	}
}
