package Projects;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import FileManager.FileReader;
import Projects.ProjectDetails.Project;
import Projects.ProjectDetails.ProjectStatus;
import Users.FYP_Coordinator;
import Users.Student;
import Users.Supervisor;
import Users.UserDetails.User;
import Users.UserDetails.UserType;

public class ProjectDB {

	FYP_Coordinator modifies;
	private ArrayList<Project> projectDB = new ArrayList<Project>(); 
	private ArrayList<Object> studentList; 
	private ArrayList<Object> supervisorList; 
	private int projectLimit = 2;
	private int sizeofdb;
	private int projectID;
	private String supervisorID;
	private String projectTitle;

	Scanner sc = new Scanner(System.in);
	Random random = new Random();

	public ProjectDB() {
		// Initialize ProjectDB (Scan Excel File)
		studentList = FileReader.readExcelFile("student_list.xlsx", new Student());
		supervisorList = FileReader.readExcelFile("faculty_list.xlsx", new Supervisor());
		projectDB = FileReader.readExcelFile("rollover_project.xlsx", new Project());
		Project lastProject = (Project) projectDB.get(projectDB.size()-1);
		sizeofdb = projectDB.size();
	}

	public void createProject(Supervisor supervisor) {
		//ask rest of project details here
		//if num of assigned > 2 then cannot create project alr 
		//else num of assigned +1
		if (supervisor.getNumAssignedProjects() < projectLimit) {
			projectID = sizeofdb + 1;
			projectTitle = setProjectTitle(supervisor);
			Project newProject = new Project(projectID, projectTitle, null, supervisor);
			sizeofdb++;
		}
		else {
			System.out.println("Error! You are unable to create anymore projects!");
		}
	}

	/**
	 * 
	 * @param newTitle
	 */
	public String setProjectTitle(Supervisor supervisor) {
		System.out.println("Input your project title");
		return projectTitle = sc.next();
	}

	public void changeSupervisor(int projectID, String supervisorID) {
		for (Project project : projectDB) {
			if (project.getProjectID() == projectID) {
				project.setSupervisor(supervisorID);
			}
		}
	}

	public void setProjectStatus(int projectId, ProjectStatus updatedStatus) {
		// if approved, then run countproject

	}

	public void deregisterProject(int projectId) { //wait do we need this if already under requests?
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

	public void exportProj(){
		//after every method, call this 
	}

	public boolean setUnavailableProject(Supervisor supervisor) {
		//get number of assigned projects 
		//if more than limit, set all projects under that supervisor as unavailable
		if (supervisor.getNumAssignedProjects() >= projectLimit) {
			for (Project project : projectDB) {
				if (supervisor.getUserID() = project.getSupervisorID) {
					setProjectStatus(project.getProjectID(), ProjectStatus.UNAVAILABLE);
				}
				return false;
			}
		}
		else return true;
	}

}