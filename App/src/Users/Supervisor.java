package Users;
import java.util.*;

import Projects.Project.Project;
import Requests.Request;
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
		// TODO - implement Supervisor.Supervisor
		throw new UnsupportedOperationException();
	}

}