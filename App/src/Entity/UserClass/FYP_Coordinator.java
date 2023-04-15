package Entity.UserClass;

// import Exceptions.InvalidInputException;

// import java.util.InputMismatchException;

// import Controller.Project.GenerateProjectReportController.GenerateReport;
// import Controller.Project.ViewProjectController.*;
// import Controller.Request.ManageRequestController.ManageRequest;
// import Controller.Request.ViewRequestController.ControllerObject.ViewAllRequestsHistory;
// import Controller.Request.ViewRequestController.ControllerObject.ViewPendingRequests;
import Entity.UserClass.UserDetails.*;

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
		super(userID, name, email, 0);
		super.setUserType(UserType.FYPCOORDINATOR);
	}

	// private void viewProjectOption(){
	// 	System.out.println("[1] View Personal Projects");
	// 	System.out.println("[2] View All Projects");
	// 	System.out.println("[0] Exit");
	// 	System.out.printf("\nEnter Option: ");
		
	// 	switch(sc.nextInt()){
	// 		case 1:
	// 			new ViewPersonalProjects(this);
	// 			break;
	// 		case 2:
	// 			new ViewAvailableProjects(this);
	// 			break;
	// 		case 0:
	// 			break;
	// 	}
	// }
}