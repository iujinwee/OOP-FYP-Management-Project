package Requests.RequestDetails;
import Projects.ProjectDetails.Project;
import Users.Student;
import Users.Supervisor;
import Users.UserDetails.User;

public class Request {

	// Student belongs;
	// Supervisor taggedTo;
	// Project modifies;
	private int requestID;
	private RequestType requestType;
	private User fromUser;
	private User toUser;
	private int projectID;
	private RequestStatus requestStatus;

	/**
	 * 
	 * @param type
	 */
	public Request(){}
	public Request(RequestType type) {
		// TODO - implement Request.Request
		throw new UnsupportedOperationException();
	}
