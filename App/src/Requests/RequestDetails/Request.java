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

	/**
	 * 
	 * @param type
	 */
	public Request(RequestType type) {
		// TODO - implement Request.Request
	public Request(int requestID) {
		this.requestStatus = RequestStatus.PENDING;
		this.fromUser = belongs;
		this.toUser = null;
		this.requestID = requestID;
		this.requestType = null;
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

	public abstract void enactRequest();

}