package Projects.ProjectDetails;

import Users.Student;
import Users.Supervisor;

public class Project {

	Supervisor supervisedBy;
	Student assignedTo;
	private int projectID;
	private String projectTitle;
	private ProjectStatus projectStatus;

	/**
	 * Represents a Project. Project is created by a Supervisor and assigned to a Student.
	 * @param id represents the Project ID.
	 * @param title represents the Project Title.
	 * @param student represents the assigned Student object.
	 * @param supervisor represents the Supervisor tagged to the project.
	 */
	public Project(){}

	public Project(int id, String title, Student student, Supervisor supervisor) {
		// Create Project
		this.projectID = id;
		this.projectTitle = title;
		this.supervisedBy = supervisor;
		this.assignedTo = student;
		this.projectStatus = ProjectStatus.AVAILABLE;
	}

	public void viewAvailableProjectDetails() {
		// View Project Details
		System.out.println("===================================================");
		System.out.println("=========    Available Project Details    =========");
		System.out.println("===================================================");
		System.out.println("> Project");
		System.out.println("Project ID: " + projectID);
		System.out.println("Project Title: " + projectTitle);
		System.out.println("Project Status: " + projectStatus);

		System.out.println("\n> Supervisor-in-charge");
		System.out.println("Supervisor Name: " + supervisedBy.getName());
		System.out.println("Supervisor Email: " + supervisedBy.getEmail());
		System.out.println("==================================================");
	}

	public void viewAllocatedProjectDetails() {
		// View Project Details
		System.out.println("===================================================");
		System.out.println("=========    Allocated Project Details    =========");
		System.out.println("===================================================");
		System.out.println("> Project");
		System.out.println("Project ID: " + projectID);
		System.out.println("Project Title: " + projectTitle);
		System.out.println("Project Status: " + projectStatus);

		System.out.println("\n> Supervisor-in-charge");
		System.out.println("Supervisor Name: " + supervisedBy.getName());
		System.out.println("Supervisor Email: " + supervisedBy.getEmail());

		System.out.println("\n> Assigned Student");
		System.out.println("Student Name: " + assignedTo.getName());
		System.out.println("Student Email: " + assignedTo.getEmail());
		System.out.println("===================================================");
	}

	public String getProjectTitle(){
		return this.projectTitle;
	}

	public ProjectStatus getProjectStatus(){
		return this.projectStatus;
	}

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
}