package Entity.UserClass;

import Entity.UserClass.UserDetails.*;

public class Supervisor extends User {

	private int numAssignedProjects=0;
	private String supervisorID;

	/**
	 * Supervisor constructor.
	 * 
	 * @param userID Unique ID of the supervisor.
	 * @param name Name of the supervisor.
	 * @param email Email address of the supervisor.
	 */
	public Supervisor(String userID, String name, String email, int numAssigned) {
		super(userID, name, email);
		this.numAssignedProjects = numAssigned;
		super.setUserType(UserType.SUPERVISOR); 
		this.supervisorID = super.getUserID();
	}
	public Supervisor(){}

	// GETTER FUNCTIONS
	public String getSupervisorID() {
		return this.supervisorID;
	}

	public void addAssignedProjects(){
		this.numAssignedProjects = this.numAssignedProjects + 1;
	}

	public void removeAssignedProjects(){
		this.numAssignedProjects = this.numAssignedProjects - 1;
	}
	
	public int getNumAssignedProjects(){
		return this.numAssignedProjects;
	}
	
	public void setNumAssignedProjects(int numAssigned) {
		this.numAssignedProjects = numAssigned;
	}
}