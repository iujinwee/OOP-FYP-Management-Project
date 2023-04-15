package Entity.UserClass;

import Entity.UserClass.UserDetails.*;

public class FYP_Coordinator extends Supervisor {

	public FYP_Coordinator() {}

	/**
	 * FYP Coordinator constructor.
	 * 
	 * @param userID Unique ID of the FYP coordinator
	 * @param name Name of the FYP coordinator
	 * @param email Email address of the FYP coordinator
	 */
	public FYP_Coordinator(String userID, String name, String email) {
		super(userID, name, email, 0);
		super.setUserType(UserType.FYPCOORDINATOR);
	}
}