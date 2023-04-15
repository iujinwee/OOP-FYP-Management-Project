package Entity.UserClass;

// import Controller.Project.ViewProjectController.ViewAvailableProjects;
// import Controller.Project.ViewProjectController.ViewPersonalProjects;
// import Controller.Request.CreateRequestController.NewRequest;
// import Controller.Request.ViewRequestController.ControllerObject.ViewOutgoingRequestsHistory;
// import Entity.DatabaseClass.FYP_CoordinatorDB;
// import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.*;
// import Exceptions.InvalidInputException;

public class Student extends User {
 	
	private String studentID;
	// private boolean assigned; 
	public Student() {}

	/**
	 * Student constructor. 
	 * 
	 * @param userID Unique ID of the student.
	 * @param name Name of the student.
	 * @param email Email address of the student.
	 */
	public Student(String userID, String name, String email) {
		super(userID, name, email);
		super.setUserType(UserType.STUDENT);
		this.studentID = super.getUserID();
	}

	// GETTER FUNCTIONS
	public String getStudentID() {
		return this.studentID;
	}

	// SETTER FUNCTIONS
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	

	// private void registerProject() throws InvalidInputException{
	// 	ViewAvailableProjects projs = new ViewAvailableProjects(this);

	// 	// View Projects
	// 	if(projs.projects.size()!=0){
	// 		System.out.printf("Select Project to register: ");
	// 		int projID = sc.nextInt();
			
	// 		if(projs.projects.contains(projID)){
	// 			FYP_CoordinatorDB FYPDB = new FYP_CoordinatorDB();
	// 			new NewRequest(RequestType.REGISTERPROJECT, this, FYPDB.findInstance(), projID);
	// 		}else{
	// 			throw new InvalidInputException(projID);
	// 		}
	// 	}
	// }

	// private void deregisterProject() throws InvalidInputException{
	// 	ViewPersonalProjects projs = new ViewPersonalProjects(this);
	// 	// View Projects
	// 	if(projs.projects.size()!=0){
	// 		System.out.println("Select Project to deregister:");
	// 		int projID = super.sc.nextInt();
			
	// 		if(projs.projects.contains(projID)){
	// 			FYPCoordinatorDB FYPDB = new FYPCoordinatorDB();
	// 			new NewRequest(RequestType.DEREGISTERPROJECT, this, FYPDB.findInstance(), projID);
	// 		}else{
	// 			throw new InvalidInputException(projID);
	// 		}
	// 	}
	// }

	// private void changeTitle() throws InvalidInputException{
	// 	ViewPersonalProjects projs = new ViewPersonalProjects(this);
	// 	// View Projects
	// 	if(projs.projects.size()!=0){
	// 		System.out.printf("Select Assigned Project to change title: ");
	// 		int projID = super.sc.nextInt();
			
	// 		if(projs.projects.contains(projID)){
	// 			new NewRequest(RequestType.CHANGETITLE, this, projDB.findInstance(projID).getSupervisor(), projID);
	// 		}else{
	// 			throw new InvalidInputException(projID);
	// 		}
	// 	}
	// }

	// private void viewAllRequests(){
	// 	new ViewOutgoingRequestsHistory(this);
	// }
}