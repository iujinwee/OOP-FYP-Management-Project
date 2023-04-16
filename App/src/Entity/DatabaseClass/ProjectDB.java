package Entity.DatabaseClass;

import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.Supervisor;

public class ProjectDB extends Database{

	private int projectLimit = 2;

	/** 
     * Project Database Constructor.
     */
    public ProjectDB(){
        super("rollover_project.xlsx", new Project());
    }

    
	/** 
	 * Method to find instance of Project object in ProjectDB, matched by the Project ID, not case sensitive.
	 * @param id Input Project ID to be found
	 * @return Project
	 */
	public Project findInstance(int id) {
        for (Object s: super.objectDB){
            Project currentProject = (Project) s;
            if(currentProject.getProjectID() == id){
                return currentProject;
            }
        }
        return new Project();
    }

	/** 
	 * Method to indicate that supervisor has reached his limit of 2 assigned projects, and no more vacancy for other projects.
	 * @param supervisor Supervisor object
	 * @return boolean
	 */
	public boolean hasVacancy(Supervisor supervisor) {
		//get number of assigned projects 
		//if more than limit, set all projects under that supervisor as unavailable
		boolean vacant = true;
		if (supervisor.getNumAssignedProjects() >= projectLimit) {
			vacant = false;

			for (Object obj : objectDB) {
				Project curProject = (Project) obj;
				if (supervisor.getUserID().compareTo(curProject.getSupervisorID())==0) {
					curProject.setProjectStatus(ProjectStatus.UNAVAILABLE); // TO CHANGE
				}
			}
			System.out.println("Number of Assigned Projects exceeded limit of 2. Unassigned Projects will be set to UNAVAILABLES.");
		}
		return vacant;
	}
}
