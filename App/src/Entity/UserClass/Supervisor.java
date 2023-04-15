package Entity.UserClass;

import Entity.UserClass.UserDetails.*;

public class Supervisor extends User {

	private int numAssignedProjects;
	private String supervisorID;

	/**
	 * Supervisor constructor.
	 * 
	 * @param userID Unique ID of the supervisor
	 * @param name Name of the supervisor
	 * @param email Email address of the supervisor
	 * @param numAssigned Number of assigned projects under supervisor
	 */
	public Supervisor(String userID, String name, String email, int numAssigned) {
		super(userID, name, email);
		setNumAssignedProjects(numAssigned);
		super.setUserType(UserType.SUPERVISOR); 
		this.supervisorID = super.getUserID();
	}
	public Supervisor(){}

	// GETTER FUNCTIONS
	/** 
	 * Method used to get unique ID of supervisor.
	 * @return String
	 */
	public String getSupervisorID() {
		return this.supervisorID;
	}

	/** 
	 * Method used to add number of assigned projects by 1.
	 */
	public void addAssignedProjects(){
		this.numAssignedProjects = this.numAssignedProjects + 1;
	}

	/** 
	 * Method used to remove number of assigned projects by 1.
	 */
	public void removeAssignedProjects(){
		this.numAssignedProjects = this.numAssignedProjects - 1;
	}
	
	
	/** 
	 * Method used to get number of assigned projects.
	 * @return int
	 */
	public int getNumAssignedProjects(){
		return this.numAssignedProjects;
	}
	
	
	/** 
	 * Method used to set number of assigned projects.
	 * @param numAssigned Number of assigned projects under supervisor
	 */
	public void setNumAssignedProjects(int numAssigned) {
		this.numAssignedProjects = numAssigned;
	}
}