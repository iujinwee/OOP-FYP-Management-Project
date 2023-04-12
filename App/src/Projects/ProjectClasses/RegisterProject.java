package Projects.ProjectClasses;

import Database.StudentDB;
import Projects.ModifyProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Users.Student;

public class RegisterProject extends ModifyProjectDB{

    private int projID;
    private Student student;
    
    public RegisterProject(int projID, Student student){
        this.projID = projID;
        this.student = student;
        initializeFiles();
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
            currentProj.setProjectStatus(ProjectStatus.RESERVED);

            System.out.printf("Successfully Registered for Project [%d] %s\n", currentProj.getProjectID(), currentProj.getProjectTitle());
        }
	}

}
