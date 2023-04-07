package Projects;
import java.util.ArrayList;

import FileManager.FileReader;
import Projects.ProjectDetails.Project;
import Projects.ProjectDetails.ProjectStatus;
import Users.FYP_Coordinator;
import Users.UserDetails.UserType;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProjectDB {

	FYP_Coordinator modifies;
	private ArrayList<Object> projectDB; 

	public ProjectDB() {
		// Initialize ProjectDB (Scan Excel File)
		projectDB = FileReader.readExcelFile("rollover_project.xlsx", new Project());
		Project lastProject = (Project) projectDB.get(projectDB.size()-1);
	}

	public void createProject(String projectTitle, String studentId, String supervisorId) {
		
	}

	/**
	 * 
	 * @param newTitle
	 */
	public void setProjectTitle(int projectId, String projectTitle) {
		// TODO - implement ProjectDB.setProjectTitle
		System.out.println("Enter new Project Title: ");
		projectTitle = sc.next();
	}

	public void setSupervisor(int projectId, String supervisorName) {
		// TODO - implement ProjectDB.setSupervisor
		System.out.println("Enter new Supervisor's Name: ");
		supervisorName = sc.next();
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
		return projectList;
	}

}