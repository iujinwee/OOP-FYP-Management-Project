package Users;
import java.util.*;

import Projects.ProjectDetails.Project;
import Requests.RequestDetails.Request;
import Users.UserRole.Administrator;

public class Supervisor extends Administrator {

	Collection<Request> sends;
	Collection<Project> create;
	private String supervisorID;
	private int numAssignedProjects;
	private int projectLimit = 2;

	/**
	 * 
	 * @param userID
	 * @param name
	 */
	public Supervisor(String userID, String name) {
		super(userID, name, name);
	}

}