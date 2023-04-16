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
	 * @param userID Unique ID of the student
	 * @param name   Name of the student
	 * @param email  Email address of the student
	 * @param bool 
	 */
	public Student(String userID, String name, String email, Boolean assigned) {
		super(userID, name, email);
		super.setUserType(UserType.STUDENT);
		this.studentID = super.getUserID();
		setAssigned(assigned);
	}

	
	/** 
	 * @return boolean
	 */
	public boolean getAssigned(){
		return this.assigned;
	}

	public void setAssigned(boolean assigned){
		this.assigned = assigned;
	}

	// GETTER FUNCTIONS
	/** 
	 * Method used to get unique ID of student.
	 * @return String
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