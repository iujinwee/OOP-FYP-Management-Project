package Users.UserRole;
import java.util.Scanner;

import Projects.ProjectDB;
import Requests.RequestDB;
import Users.UserDetails.User;


public interface Administrator {
	//test
	/**
	 * 
	 * @param RequestDB
	 */
	public Boolean createProject();

	public Boolean changeTitle();

	public void manageRequests();

	public void approve(int RequestID);

	public void reject(int RequestID);
}