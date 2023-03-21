package Users;
import java.util.*;

import Projects.Project.Project;
import Requests.Request;
import Users.UserRole.Requestor;

public class Student extends Requestor {

	Collection<Request> sends;
	Project registeredTo;
	private String studentID;

	/**
	 * 
	 * @param userID
	 * @param name
	 */
	public Student(String userID, String name) {
		
	}

	public void viewRegisteredProject() {
		// TODO - implement Student.viewRegisteredProject
		throw new UnsupportedOperationException();
	}

}