package Controller.Project.ModifyProject;

import Entity.ProjectClass.ProjectStatus;
import Entity.ProjectClass.Project;
import Entity.UserClass.Student;
import Entity.UserClass.Supervisor;
import Entity.DatabaseClass.SupervisorDB;

public class DeregisterProject extends ModifyProject {

    private int projID;
    private Student student;
    
    /** 
     * Deregister Project Constructor.
     * @param projID Unique ID of Project Object
     * @param student Student Object
     */
    public DeregisterProject(int projID, Student student) {
        super();
        this.projID = projID;
        this.student = student;
        updateDB();
        exportDB();
    }
    
    @Override
	public void updateDB() {	
        Project currentProj = projDB.findInstance(projID);
        currentProj.addRejected(student.getUserID());
        currentProj.setProjectStatus(ProjectStatus.AVAILABLE);
        currentProj.setStudent(null);
        SupervisorDB supDB = new SupervisorDB();
        Supervisor curSup = supDB.findInstance(currentProj.getSupervisorID());
        curSup.removeAssignedProjects();
        if(curSup.getNumAssignedProjects() < 2) {
            for (Object obj : projDB.objectDB) {
                Project curProject = (Project) obj;
                if (curSup.getUserID().compareTo(curProject.getSupervisorID())==0 && curProject.getProjectStatus() == ProjectStatus.UNAVAILABLE) {
                    curProject.setProjectStatus(ProjectStatus.AVAILABLE);
                }
            }
        }
        supDB.exportDB();
        System.out.printf("Successfully deregistered %s from Project [%d]\n", student.getName(), projID);
	}
}
