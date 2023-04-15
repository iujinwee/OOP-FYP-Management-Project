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
	
	/**
	 * Request constructor.
	 * 
	 * @param ID Unique ID of request
	 * @param fromUser User request made from
	 * @param toUser User request made to
	 * @param status Status of request
	 * @param type Type of request
	 * @param projectID Unique ID of project 
	 */
	public Request(int ID, User fromUser, User toUser, RequestStatus status, RequestType type, int projectID) {
		this.requestStatus = status;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.requestID = ID;
		this.requestType = type;
		this.projectID = projectID;
	}

	
	/** 
	 * Method used to get type of request.
	 * @return RequestType
	 */
	public RequestType getRequestType() {
		return this.requestType;
	}

	/** 
	 * Method used to get status of request.
	 * @return RequestStatus
	 */
	public RequestStatus getRequestStatus() {
		return this.requestStatus;
	}

	/** 
	 * Method used to set status of request.
	 * @param requestStatus New status of request
	 */
	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	/** 
	 * Method used to set new title of request.
	 * @param newTitle New title of request
	 */
	public void setNewTitle(String newTitle){
		this.newTitle = newTitle;
	}

	/** 
	 * Method used to set new supervisor.
	 * @param newSupervisor Unique ID of new supervisor 
	 */
	public void setNewSupervisor(String newSupervisor){
		this.newSupervisorID = newSupervisor;
	}

	/** 
	 * Method used to get user request is made from.
	 * @return User
	 */
	public User getFromUser() {
		return this.fromUser;
	}

	/** 
	 * Method used to get user request is made to.
	 * @return User
	 */
	public User getToUser() {
		return this.toUser;
	}

	/** 
	 * Method used to get unique ID of request.
	 * @return int
	 */
	public int getRequestID() {
		return this.requestID;
	}

	/** 
	 * Method used to get unique ID of project.
	 * @return int
	 */
	public int getProjectID() {
		return this.projectID;
	}

	/** 
	 * Method used to get new title of request.
	 * @return Stirng
	 */
	public String getNewTitle(){
		return this.newTitle;
	}

	/** 
	 * Method used to get unqiue ID of user request is made from.
	 * @return String
	 */
	public String getfromUserID(){
		if(fromUser!=null){
			return fromUser.getUserID();
		}
		return "";
	}

	/** 
	 * Method used to get unqiue ID of user request is made to.
	 * @return String
	 */
	public String gettoUserID(){
		if(toUser!=null){
			return toUser.getUserID();
		}
		return "";
	}

	/** 
	 * Method used to get unqiue ID of new supervisor.
	 * @return String
	 */
	public String getNewSupervisor(){
		return this.newSupervisorID;
	}
}