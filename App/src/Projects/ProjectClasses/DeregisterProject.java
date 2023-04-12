package Projects.ProjectClasses;

import Database.StudentDB;
import Projects.ModifyProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Users.Student;

public class DeregisterProject extends ModifyProjectDB{

    private int projID;
    private Student student;
    
    public DeregisterProject(int projID, Student student){
        this.projID = projID;
        this.student = student;
        initializeFiles();
        updateDB();
        exportDB();
    }
    
    @Override
	public void updateDB() {		
        projDB.findInstance(projID).addRejected(student.getUserID());
        projDB.findInstance(projID).setProjectStatus(ProjectStatus.AVAILABLE);
        System.out.printf("Successfully deregistered %s from Project [%d]\n", student.getName(), projID);
	}

}
