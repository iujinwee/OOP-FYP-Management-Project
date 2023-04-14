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
	 * Represents a Project. Project is created by a Supervisor and assigned to a Student.
	 * @param id represents the Project ID.
	 * @param title represents the Project Title.
	 * @param student represents the assigned Student object.
	 * @param supervisor represents the Supervisor tagged to the project.
	 */
	public Project(){}

	public Project(int id){
		// Create Project
		ArrayList<String> rejList = new ArrayList<>();
		this.projectID = id; 
		this.assignedTo = null;
		this.rejectedID = rejList;
		this.projectStatus = ProjectStatus.AVAILABLE;
	}

	public Project(int id, String title, Student student, Supervisor supervisor, ProjectStatus status, ArrayList<String> rejectedId) {
		this.projectID = id;
		this.projectTitle = title;
		this.supervisedBy = supervisor;
		this.assignedTo = student;
		this.rejectedID = rejectedId;
		this.projectStatus = status;
	}

	public int getProjectID(){
		return projectID;
	}

	public String getProjectTitle(){
		return projectTitle;
	}

	public ProjectStatus getProjectStatus(){
		return projectStatus;
	}

	public String getSupervisorID(){
		if((supervisedBy!=null)&&(supervisedBy.getUserID()!=null)){
			return supervisedBy.getUserID();
		}
		return "";
	}

	public String getStudentID(){
		if((assignedTo!=null)&&(assignedTo.getUserID()!=null)){
			return assignedTo.getUserID();
		}
		return "";
	}

	public ArrayList<String> getRejected(){
		return this.rejectedID;
	}

	public Student getStudent(){
		return this.assignedTo;
	}

	public Supervisor getSupervisor(){
		return this.supervisedBy;
	}


	// SETTER FUNCTIONS 
	public void setProjectStatus(ProjectStatus status){
		this.projectStatus = status;
	}
	
	public void setProjectTitle(String title){
		this.projectTitle = title;
	}

	public void setStudent(Student student){
		this.assignedTo = student;
	}

	public void setSupervisor(Supervisor supervisor){
		this.supervisedBy = supervisor;
	}

	public void addRejected(String studentID){
		this.getRejected().add(studentID);
	}
}