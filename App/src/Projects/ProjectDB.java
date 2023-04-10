package Projects;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Database.FileHandler;
import Users.FYP_Coordinator;
import Users.Student;
import Users.Supervisor;
import Users.UserDetails.User;
import Users.UserDetails.UserType;

public class ProjectDB {

	FYP_Coordinator modifies;
	private ArrayList<Object> projectDB; 
	private ArrayList<Object> studentList; 
	private ArrayList<Object> supervisorList; 

	private int projectLimit = 2;
	private int sizeofdb;
	private Project currentProject;
	private int currentIndex; 

	Scanner sc = new Scanner(System.in);
	Random random = new Random();

	public ProjectDB() {
		// Initialize ProjectDB (Scan Excel File)
		studentList = FileReader.readExcelFile("student_list.xlsx", new Student());
		supervisorList = FileReader.readExcelFile("faculty_list.xlsx", new Supervisor());
		projectDB = FileReader.readExcelFile("rollover_project.xlsx", new Project());
		sizeofdb = projectDB.size();
	}

	public void createProject(Supervisor supervisor) {
		//ask rest of project details here
		//if num of assigned > 2 then cannot create project alr 
		//else num of assigned +1
		if (hasVacancy(supervisor)) {
			int newID = ++sizeofdb; 
			currentProject = new Project(newID); // Default 
			currentProject.setSupervisor(supervisor); 
			setNewTitle(newID); // Ask for input 
		}
		else {
			System.out.println("Error! You are unable to create anymore projects!");
		}
	}


	public Project findProject(int id){
		int counter = 0;
		for (Object obj: projectDB){
			Project curProj = (Project) obj;
			if(curProj.getProjectID() == id){
				currentProject = curProj;
				currentIndex = counter;
				return currentProject;
			}
			counter++;
		}
		return new Project();
	}

	/**
	 * 
	 * @param newTitle
	 */
	public void setNewTitle(int projectID) {

		findProject(projectID);

		System.out.println("Input your project title");
		String title = sc.next();
		currentProject.setProjectTitle(title);
	}

	public void changeSupervisor(int projectID, Supervisor supervisor) {
		findProject(projectID);
		currentProject.setSupervisor(supervisor);
	}

	public void setProjectStatus(int projectID, ProjectStatus updatedStatus) {
		// if approved, then run countproject
		findProject(projectID);
		currentProject.setProjectStatus(updatedStatus);
	}

	public void deregisterProject(int projectID, String studentID) { //wait do we need this if already under requests?
		findProject(projectID);
		currentProject.addRejected(studentID);
	}

	public boolean allocateStudent(int projectID, Student student){
		findProject(projectID);
		
		// Check if student has been rejected previously
		if(currentProject.getRejected().contains(student.getUserID())){
			System.out.println("Student has been rejected previously.");
			return false;
		}

		// Allocate student
		currentProject.setStudent(student);
		return true;
	}

	/**
	 * 
	 * @param userType
	 */
	public void viewAllProjects(UserType userType) {
		System.out.println("========    Project List    ========");
		for (Object obj: projectDB){
			Project curProj = (Project) obj;
			System.out.printf("[%d] %s\n", curProj.getProjectID(), curProj.getProjectTitle());
		}
	}

	public void exportProj(){
		//after every method, call this 
	}

	public boolean hasVacancy(Supervisor supervisor) {
		//get number of assigned projects 
		//if more than limit, set all projects under that supervisor as unavailable
		if (supervisor.getNumAssignedProjects() >= projectLimit) {
			for (Object obj : projectDB) {
				Project curProject = (Project) obj;
				if (supervisor.getUserID() == curProject.getSupervisorID()) {
					setProjectStatus(curProject.getProjectID(), ProjectStatus.UNAVAILABLE);
				}
				return false;
			}
		}
		
		return true;
	}

}