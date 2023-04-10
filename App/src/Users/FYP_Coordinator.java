package Users;

import Requests.RequestDetails;
import Users.UserDetails.UserType;

public class FYP_Coordinator extends Supervisor {

	public FYP_Coordinator() {}

	/**
	 * FYP Coordinator constructor.
	 * 
	 * @param userID Unique ID of the FYP coordinator.
	 * @param name Name of the FYP coordinator.
	 * @param email Email address of the FYP coordinator.
	 */
	public FYP_Coordinator(String userID, String name, String email) {
		super(userID, name, email);
		super.setType(UserType.FYPCOORDINATOR);
	}

	/**
	 * 
	 * @param request
	 */
	private void changeSupervisor(Request request) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param request
	 */
	private void allocateProject(Request request) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param request
	 */
	private void deregisterProject(Request request) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param filter
	 */
	public void generateReport(FilterType filter) {
		throw new UnsupportedOperationException();
	}

}