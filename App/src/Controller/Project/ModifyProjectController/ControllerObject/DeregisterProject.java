package Controller.Project.ModifyProjectController.ControllerObject;

import Controller.Project.ModifyProjectController.ModifyProjectController;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.Student;
import Entity.DatabaseClass.SupervisorDB;

public class DeregisterProject extends ModifyProjectController{

    private int projID;
    private Student student;
    
    public DeregisterProject(int projID, Student student){
        this.projID = projID;
        this.student = student;
        loadFiles();
        updateDB();
        exportDB();
    }
    
    @Override
	public void updateDB() {		
        projDB.findInstance(projID).addRejected(student.getUserID());
        projDB.findInstance(projID).setProjectStatus(ProjectStatus.AVAILABLE);
        SupervisorDB supDB = new SupervisorDB();
        supDB.findInstance(projDB.findInstance(projID).getSupervisorID()).removeAssignedProjects();
        supDB.exportDB();
        System.out.printf("Successfully deregistered %s from Project [%d]\n", student.getName(), projID);
	}

}
