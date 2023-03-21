import Users.Student;
import Users.Supervisor;

package Projects.Project;
public class Project {

	Supervisor supervisedBy;
	Student taggedTo;
	private int projectID;
	private String projectTitle;
	private Student student;
	private Supervisor supervisor;
	private ProjectStatus projectStatus;

	/**
	 * 
	 * @param title
	 * @param studentID
	 * @param supervisorID
	 */
	public Project(String title, String studentID, String supervisorID) {
		// TODO - implement Project.Project
		throw new UnsupportedOperationException();
	}

	public void viewProjectDetails() {
		// TODO - implement Project.viewProjectDetails
		throw new UnsupportedOperationException();
	}

}