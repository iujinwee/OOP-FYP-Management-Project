package Users.UserRole;

import Requests.RequestDB;
import Requests.RequestDetails.RequestType;
import Users.UserDetails.User;

public abstract class Requestor extends User {

	private RequestDB reqDB;
	/**
	 * 
	 * @param RequestDB
	 */

	public Requestor(String userID, String name, String email){
		super(userID, name, email);
		reqDB = new RequestDB();
	}
	
	public void sendRequest(RequestType type){
		reqDB.createRequest(type);
	}

	abstract public void viewUserMenu();
}