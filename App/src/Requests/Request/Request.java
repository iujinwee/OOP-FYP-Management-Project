package Requests.Request;
import Projects.Project.Project;
import Users.Student;
import Users.Supervisor;
import Users.User.User;

public abstract class Request {

	Student belongs;
	Supervisor taggedTo;
	Project modifies;
	private int requestID;
	private RequestType requestType;
	private User fromUser;
	private User toUser;
	private RequestStatus requestStatus;

	/**
	 * 
	 * @param type
	 */
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

	public abstract void approve();
	public abstract void reject();

}