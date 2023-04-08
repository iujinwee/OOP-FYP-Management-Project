package Requests.RequestDetails;
import Projects.ProjectDetails.Project;
import Users.Student;
import Users.Supervisor;
import Users.UserDetails.User;

public class Request {

	Student belongs;
	Supervisor taggedTo;
	private RequestType requestType;
	private int requestID;
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
	}
	public Request(int id, User fromUser, User toUser, RequestType type, RequestStatus status, int projectID) {
		this.requestStatus = status;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.requestID = id;
		this.requestType = type;
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