package Requests.RequestDetails;
import Projects.ProjectDetails.Project;
import Users.Student;
import Users.Supervisor;
import Users.UserDetails.User;

public abstract class Request {

	Student belongs;
	Supervisor taggedTo;
	private RequestType requestType;
	private User fromUser;
	private User toUser;
	private int projectID;
	private RequestStatus requestStatus;
	private int requestID;

	/**
	 * 
	 * @param type
	 */
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

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
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

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public int getRequestID() {
		return this.requestID;
	}

}