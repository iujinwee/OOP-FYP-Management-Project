package Entity.UserClass;

import Entity.UserClass.UserDetails.*;

public class Student extends User {

	private boolean assigned; 
	private String studentID;
	public Student() {
	}

	/**
	 * Student constructor.
	 * 
	 * @param userID Unique ID of the student.
	 * @param name   Name of the student.
	 * @param email  Email address of the student.
	 */
	public Student(String userID, String name, String email, Boolean assigned) {
		super(userID, name, email);
		super.setUserType(UserType.STUDENT);
		this.studentID = super.getUserID();
		setAssigned(assigned);
	}

	public boolean getAssigned(){
		return this.assigned;
	}

	public void setAssigned(boolean assigned){
		this.assigned = assigned;
	}

	// GETTER FUNCTIONS
	public String getStudentID() {
		return this.studentID;
	}

	// SETTER FUNCTIONS
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
}