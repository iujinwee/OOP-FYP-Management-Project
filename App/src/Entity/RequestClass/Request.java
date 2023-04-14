package Entity.RequestClass;

import Entity.UserClass.UserDetails.User;

public class Request {

	private RequestType requestType;
	private int requestID;
	private User fromUser;
	private User toUser;
	private int projectID;
	private RequestStatus requestStatus;
	private String newTitle; 
	private String newSupervisorID;

	public Request(){}
	
	public Request(int ID, User fromUser, User toUser, RequestStatus status, RequestType type, int projectID) {
		this.requestStatus = status;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.requestID = ID;
		this.requestType = type;
		this.projectID = projectID;
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

	public void setNewTitle(String newTitle){
		this.newTitle = newTitle;
	}

	public void setNewSupervisor(String newSupervisor){
		this.newSupervisorID = newSupervisor;
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

	public String getNewTitle(){
		return this.newTitle;
	}

	public String getfromUserID(){
		if(fromUser!=null){
			return fromUser.getUserID();
		}
		return "";
	}

	public String gettoUserID(){
		if(toUser!=null){
			return toUser.getUserID();
		}
		return "";
	}

	public String getNewSupervisor(){
		return this.newSupervisorID;
	}
}