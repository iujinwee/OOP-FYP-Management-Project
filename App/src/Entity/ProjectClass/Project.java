package Entity.ProjectClass;

import java.util.ArrayList;

import Entity.UserClass.Student;
import Entity.UserClass.Supervisor;

public class Project {

	Supervisor supervisedBy;
	Student assignedTo;
	private int projectID;
	private String projectTitle;
	private ProjectStatus projectStatus;
	private ArrayList<String> rejectedID;

	/**
	 * Project Constructor.
	 * Represents a Project. Project is created by a Supervisor and assigned to a Student.
	 */
	public Project(){}

	/**
	 * Project Constructor.
	 * Represents a Project. Project is created by a Supervisor and assigned to a Student.
	 * @param id Unique ID of Project Object
	 */
	public Project(int id){
		// Create Project
		ArrayList<String> rejList = new ArrayList<>();
		this.projectID = id; 
		this.assignedTo = null;
		this.rejectedID = rejList;
		this.projectStatus = ProjectStatus.AVAILABLE;
	}

	/**
	 * Project Constructor.
	 * Represents a Project. Project is created by a Supervisor and assigned to a Student.
	 * @param id Unique ID of Project Object
	 * @param title Project Title
	 * @param student Assigned Student Object
	 * @param supervisor Supervisor Object tagged to project
	 * @param status Project Status
	 * @param rejectedId Array list of deregistered students
	 */
	public Project(int id, String title, Student student, Supervisor supervisor, ProjectStatus status, ArrayList<String> rejectedId) {
		this.projectID = id;
		this.projectTitle = title;
		this.supervisedBy = supervisor;
		this.assignedTo = student;
		this.rejectedID = rejectedId;
		this.projectStatus = status;
	}

	
	/** 
	 * Method to get unique ID of project.
	 * @return int
	 */
	public int getProjectID(){
		return projectID;
	}

	/** 
	 * Method to get title of project.
	 * @return String
	 */
	public String getProjectTitle(){
		return projectTitle;
	}

	/** 
	 * Method to get status of project.
	 * @return ProjectStatus
	 */
	public ProjectStatus getProjectStatus(){
		return projectStatus;
	}

	/** 
	 * Method to get unique ID of supervisor.
	 * @return String
	 */
	public String getSupervisorID(){
		if((supervisedBy!=null)&&(supervisedBy.getUserID()!=null)){
			return supervisedBy.getUserID();
		}
		return "";
	}

	/** 
	 * Method to get unique ID of student.
	 * @return String
	 */
	public String getStudentID(){
		if((assignedTo!=null)&&(assignedTo.getUserID()!=null)){
			return assignedTo.getUserID();
		}
		return "";
	}

	/** 
	 * Method to get array list of deregistered student ID.
	 * @return ArrayList
	 */
	public ArrayList<String> getRejected(){
		return this.rejectedID;
	}

	/** 
	 * Method to get student the project is assigned to.
	 * @return Student
	 */
	public Student getStudent(){
		return this.assignedTo;
	}

	/** 
	 * Method to get supervisor the project is supervised by.
	 * @return Supervisor
	 */
	public Supervisor getSupervisor(){
		return this.supervisedBy;
	}


	// SETTER FUNCTIONS 
	/** 
	 * Method to set status of project.
	 * @param status New status of project
	 */
	public void setProjectStatus(ProjectStatus status){
		this.projectStatus = status;
	}
	
	/** 
	 * Method to set title of project.
	 * @param title New title of project
	 */
	public void setProjectTitle(String title){
		this.projectTitle = title;
	}

	/** 
	 * Method to set student the project is assigned to.
	 * @param student Assigned student object
	 */
	public void setStudent(Student student){
		this.assignedTo = student;
	}

	/** 
	 * Method to set supervisor the project is supervised by.
	 * @param supervisor Supervisor object project is supervised by
	 */
	public void setSupervisor(Supervisor supervisor){
		this.supervisedBy = supervisor;
	}

	/** 
	 * Method to add unique ID of student who deregistered.
	 * @param studentID Unique ID of deregistered student
	 */
	public void addRejected(String studentID){
		this.getRejected().add(studentID);
	}

	/** 
	 * Method to get Basic Project Information - Project Status, Project ID, Project Title.
	 * @return int
	 */
	public int viewBasicProjectInfo(){
		System.out.printf("| %-11s | [%-2d] %s \n", projectStatus, projectID, projectTitle);
		return projectID;
	}
    
	/** 
	 * Method to get Full Project Information.
	 * @return int
	 */
	public int viewFullProjectInfo() {

		// System.out.println("\n****************************************************************");
        // System.out.println("****************         Project Details        ****************");
        // System.out.println("****************************************************************\n");

       // View Project Details
       System.out.println("================================================================");
		System.out.println("| > Project");
		System.out.println("| Project ID: " + projectID);
		System.out.println("| Project Title: " + projectTitle);
		System.out.println("| Project Status: " + projectStatus);
        System.out.println("================================================================");

		System.out.println("| > Supervisor-in-charge");
		System.out.println("| Supervisor Name: " + supervisedBy.getName());
		System.out.println("| Supervisor Email: " + supervisedBy.getEmail());
        System.out.println("================================================================");

		String name = assignedTo.getName(); 
		if(name == null){
			name = "< Empty > ";
		}

		String email = assignedTo.getEmail(); 
		if(email == null){
			email = "< Empty > ";
		}
		
		if((projectStatus == ProjectStatus.ALLOCATED) | (projectStatus == ProjectStatus.RESERVED)){
			System.out.println("| > Assigned Student");
			System.out.println("| Student Name: " + name);
			System.out.println("| Student Email: " + email);
            System.out.println("================================================================");
		}
		return projectID;
    }
}