package Controller.Project.ModifyProjectController.ControllerObject;

import Controller.Project.ModifyProjectController.ModifyProjectController;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.Student;

public class RegisterProject extends ModifyProjectController{

    private int projID;
    private Student student;
    
    public RegisterProject(int projID, Student student){
        this.projID = projID;
        this.student = student;
        loadFiles();
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

            System.out.println("=================================================================================");
            System.out.printf("Successfully Registered for Project [%d] %s\n", currentProj.getProjectID(), currentProj.getProjectTitle());
            System.out.println("=================================================================================");

        }
	}

}
