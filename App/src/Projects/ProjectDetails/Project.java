package Projects.ProjectDetails;

import Users.Student;
import Users.Supervisor;

public class Project {

	Supervisor supervisedBy;
	Student taggedTo;
	private int projectID;
	private String projectTitle;
	private String studentID;
	private String supervisorID;
	private ProjectStatus projectStatus;

	/**
	 * 
	 * @param title
	 * @param studentID
	 * @param supervisorID
	 */
	public Project(){}

	public Project(int id, String title, String studentID, String supervisorID) {
		this.projectID = id;
		this.projectTitle = title;
		this.studentID = studentID; 
		this.supervisorID = supervisorID;
	}

	public void viewProjectDetails() {
		// View Project Details
	}

	public String getProjectTitle(){
		return this.projectTitle;
	}

	
	public String getStudent(){
		
	}
	
	public String getSupervisor(){

	}

	public void setProjectTitle(String title){
		this.projectTitle = title;
	}

	public void setStudent(String studentId){

	}

	public void setSupervisor(String supervisorId){

	}
}