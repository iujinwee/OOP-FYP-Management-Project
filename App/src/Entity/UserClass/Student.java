package Entity.UserClass;

// import Controller.Project.ViewProjectController.ViewAvailableProjects;
// import Controller.Project.ViewProjectController.ViewPersonalProjects;
// import Controller.Request.CreateRequestController.NewRequest;
// import Controller.Request.ViewRequestController.ControllerObject.ViewOutgoingRequestsHistory;
// import Entity.DatabaseClass.FYP_CoordinatorDB;
// import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.*;
// import Exceptions.InvalidInputException;

public class Student extends User {

	private boolean assigned; 
	private String studentID;
	public Student() {
	}

	/**
	 * Student constructor.
	 * 
	 * @param userID Unique ID of the student
	 * @param name   Name of the student
	 * @param email  Email address of the student
	 * @param bool 
	 */
	public Student(String userID, String name, String email, Boolean bool) {
		super(userID, name, email);
		super.setUserType(UserType.STUDENT);
		this.studentID = super.getUserID();
		setAssigned(bool);
	}

	
	/** 
	 * @return boolean
	 */
	public boolean getAssigned(){
		return this.assigned;
	}

	public void setAssigned(boolean bool){
		this.assigned = bool;
	}

	// GETTER FUNCTIONS
	/** 
	 * Method used to get unique ID of student.
	 * @return Unique ID of student
	 */
	public String getStudentID() {
		return this.studentID;
	}

	// SETTER FUNCTIONS
	/** 
	 * Method used to set unique ID of student.
	 * @param studentID Unique ID of student
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
}