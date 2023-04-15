package Controller.Project.ModifyProjectController.ControllerObject;

import Controller.Project.ModifyProjectController.ModifyProjectController;
import Entity.DatabaseClass.SupervisorDB;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.Student;
import Entity.UserClass.Supervisor;

public class RegisterProject extends ModifyProjectController{

    private int projID;
    private Student student;
    
    public RegisterProject(int projID, Student student){
        super();
        this.projID = projID;
        this.student = student;
        updateDB();
        exportDB();
    }
    
    @Override
	public void updateDB() {		

		// Check if student has been rejected previously
		if(projDB.findInstance(projID).getRejected().contains(student.getUserID())){
			System.out.println("Student has been rejected previously.");
		}else{
            // Allocate student
            Project currentProj = projDB.findInstance(projID);
            currentProj.setStudent(student);
            currentProj.setProjectStatus(ProjectStatus.ALLOCATED);
            SupervisorDB supDB = new SupervisorDB();
            Supervisor curSup = supDB.findInstance(currentProj.getSupervisor().getUserID());
            curSup.addAssignedProjects();
            if(curSup.getNumAssignedProjects() == 2){
                for (Object obj : projDB.objectDB) {
                    Project curProject = (Project) obj;
                    if (curSup.getUserID().compareTo(curProject.getSupervisorID())==0 && curProject.getProjectStatus() == ProjectStatus.AVAILABLE) {
                        curProject.setProjectStatus(ProjectStatus.UNAVAILABLE);
                    }
                }
            }
            supDB.exportDB();

            System.out.println("=================================================================================");
            System.out.printf("Successfully Registered for Project [%d] %s\n", currentProj.getProjectID(), currentProj.getProjectTitle());
            System.out.println("=================================================================================");

        }
	}

}
