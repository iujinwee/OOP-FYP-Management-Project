package Projects;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import FileManager.FileReader;
import Projects.ProjectDetails.Project;
import Projects.ProjectDetails.ProjectStatus;
import Users.FYP_Coordinator;
import Users.UserDetails.UserType;

public class ProjectDB {

	FYP_Coordinator modifies;
	private ArrayList<Object> projectDB; 
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

	public void createProject(Supervisor Supervisor) {
		//ask rest of project details here
		//if num of assigned > 2 then cannot create project alr 
		//else num of assigned +1
		if () {
			supervisorID = jgkjk; //get supervisor id method
			projectID = random.nextInt(); //sequential
			setSupervisor(projectID,supervisorName);
			setProjectTitle(supervisorID);
			//how to make studentID empty ah? HELPPPPPP
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
	public void setProjectTitle(String supervisorId) {
		System.out.println("Input your project title");
		projectTitle = sc.next();
	}

	public void setSupervisor(int projectId, String supervisorName) {
		// TODO - implement ProjectDB.setSupervisor
		throw new UnsupportedOperationException();
	}

	public void setProjectStatus(int projectId, ProjectStatus updatedStatus) {
		// TODO - implement ProjectDB.setProjectStatus
		throw new UnsupportedOperationException();
		// if approved, then run countproject
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

	public void exportProj(){
		//after every method, call this 
	}

	public boolean setUnavailableProject(Supervisor Supervisor) {
		//get number of assigned projects 
		//if more than limit, set all projects under that supervisor as unavailable
	}

}