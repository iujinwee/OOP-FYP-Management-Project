package Database;

import Projects.Project;
import Projects.ProjectStatus;
import Users.*;

public class ProjectDB extends Database{

	private int projectLimit = 2;

    public ProjectDB(){
        super("rollover_project.xlsx", new Project());
    }

    public Project findInstance(int id) {
        for (Object s: super.objectDB){
            Project currentProject = (Project) s;
            if(currentProject.getProjectID() == id){
                return currentProject;
            }
        }
        return new Project();
    }
    
	// public void changeSupervisor(int projectID, Supervisor supervisor) {
        
	// 	findInstance(projectID).setSupervisor(supervisor);
        
    //     super.exportDB();
	// }

	// public void setProjectStatus(int projectID, ProjectStatus updatedStatus) {
	// 	// if approved, then run countproject
	// 	findInstance(projectID).setProjectStatus(updatedStatus);

    //     super.exportDB();
	// }

	// public void deregisterProject(int projectID, String studentID) { 
		
	// 	findInstance(projectID).addRejected(studentID);

    //     super.exportDB();
	// }

	public boolean hasVacancy(Supervisor supervisor) {
		//get number of assigned projects 
		//if more than limit, set all projects under that supervisor as unavailable
		if (supervisor.getNumAssignedProjects() >= projectLimit) {
			for (Object obj : super.objectDB) {
				Project curProject = (Project) obj;
				if (supervisor.getUserID().compareTo(curProject.getSupervisorID())==0) {
					setProjectStatus(curProject.getProjectID(), ProjectStatus.UNAVAILABLE);
				}
				return false;
			}
		}
		return true;
	}
}
