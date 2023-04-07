package Users.UserRole;
import Projects.ProjectDB;
import Requests.RequestDB;
import Users.UserDetails.User;

public class Administrator extends User implements ManageRequestMenu {
	//test
	/**
	 * 
	 * @param RequestDB
	 */

	private RequestDB reqDB;
	private ProjectDB projDB; 
	
	public Administrator(String userID, String name, String email){
		
		// Call Constructor
		super(userID, name, email);

		// Initialize DB 
		reqDB = new RequestDB();
		projDB = new ProjectDB();

		// Get User 
	}

	public void manageRequests(int RequestDB) {
		
	}

	public isBoolean createProject() {
		
	}

	public isBoolean changeTitle() {
		
	}

	@Override
	public void viewUserMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approve() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reject() {
		// TODO Auto-generated method stub
		
	}
}