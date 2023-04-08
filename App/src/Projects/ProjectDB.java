package Projects;

import Projects.ProjectDetails.Project;
import Projects.ProjectDetails.ProjectStatus;
import Users.FYP_Coordinator;
import Users.UserDetails.UserType;

public class ProjectDB {

	FYP_Coordinator modifies;
	private Project[] projectDB;

	public ProjectDB() {
		// TODO - implement ProjectDB.ProjectDB
		throw new UnsupportedOperationException();
	}

	public void createProject(String projectTitle, String studentId, String supervisorId) {
		// TODO - implement ProjectDB.createProject
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newTitle
	 */
	public void setProjectTitle(int projectId, String projectTitle) {
		// TODO - implement ProjectDB.setProjectTitle
		throw new UnsupportedOperationException();
	}

	public void setSupervisor(int projectId, String supervisorName) {
		// TODO - implement ProjectDB.setSupervisor
		throw new UnsupportedOperationException();
	}

	public void setProjectStatus(int projectId, ProjectStatus updatedStatus) {
		// TODO - implement ProjectDB.setProjectStatus
		throw new UnsupportedOperationException();
	}

	public void deregisterProject(int projectId) {
		// TODO - implement ProjectDB.deregisterProject
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userType
	 */
	public void viewProjects(UserType userType) {
		// TODO - implement ProjectDB.viewProjects
		throw new UnsupportedOperationException();
	}

}