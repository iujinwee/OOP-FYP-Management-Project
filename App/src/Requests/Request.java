package Requests;
import Projects.Project;
import Users.Student;
import Users.Supervisor;
import Users.UserDetails.User;

public class Request {

	private RequestType requestType;
	private int requestID;
	private User fromUser;
	private User toUser;
	private int projectID;
	private RequestStatus requestStatus;

	public Request(){}
	
	public Request(int ID, User fromUser, User toUser, RequestStatus status, RequestType type, int projectID) {
		this.requestStatus = status;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.requestID = ID;
		this.requestType = type;
		this.projectID = projectID;
		throw new UnsupportedOperationException();
	}

	public RequestType getRequestType() {
		return this.requestType;
	}

	public RequestStatus getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public User getFromUser() {
		return this.fromUser;
	}

	public User getToUser() {
		return this.toUser;
	}

	public int getRequestID() {
		return this.requestID;
	}

	public int getProjectID() {
		return this.projectID;
	}
}