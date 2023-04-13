package Entity.UserClass;


import Controller.Project.ViewProjectController.ControllerObject.ViewAvailableProjects;
import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Controller.Request.CreateRequestController.ControllerObject.NewChangeTitleRequest;
import Controller.Request.CreateRequestController.ControllerObject.NewDeregisterRequest;
import Controller.Request.CreateRequestController.ControllerObject.NewRegisterRequest;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewOutgoingRequestsHistory;
import Entity.UserClass.UserDetails.*;
import Exceptions.InvalidInputException;

public class Student extends User {

	private boolean assigned; 
	public int numRegisteredReq; 
	public Student() {}

	/**
	 * Student constructor.
	 * 
	 * @param userID Unique ID of the student.
	 * @param name   Name of the student.
	 * @param email  Email address of the student.
	 */
	public Student(String userID, String name, String email, Boolean bool) {
		super(userID, name, email);
		super.setUserType(UserType.STUDENT);
		numRegisteredReq = 0 ; 
	}

	@Override
	public void viewUserMenu() {
		System.out.println("=============  MENU  ==============");
		System.out.println("[1] Show Available Projects.");
		System.out.println("[2] Show Registered Project.");
		System.out.println("[3] Register Project.");
		System.out.println("[4] Deregister Project.");
		System.out.println("[5] Change Assigned Project Title.");
		System.out.println("[6] View All Requests.");
		System.out.println("[0] Exit Program.");
	}

	@Override
	public void getInput() throws InvalidInputException{
		int choice = -1;

		while (choice != 0){	

			// Show User Menu
			viewUserMenu();


			System.out.printf("\nEnter Option: ");
			choice = sc.nextInt();

				switch(choice){
					case 1: 
						System.out.println("\nOption [1] selected! - Show Available Projects");
						if(!assigned){
							new ViewAvailableProjects(this);
						}else{
							System.out.println("You are already assigned to a project!\n");
						}
						break;
		
					case 2: 
						System.out.println("\nOption [2] selected! - Show Registered Project.");
						if(assigned){
							new ViewPersonalProjects(this);
						}else{
							System.out.println("You are not assigned to a project!\n");
						}
						break;
		
					case 3:
						System.out.println("\nOption [3] selected! - Register Project.");
						if(!assigned){
							new NewRegisterRequest(this);
						}else{
							System.out.println("You are already assigned to a project!\n");
						}
						break;
		
					case 4:	
						System.out.println("\nOption [4] selected! - Deregister Project.");
						if(assigned){
							new NewDeregisterRequest(this);
						}else{
							System.out.println("You are not assigned to a project!\n");
						}
						break;
		
					case 5:
						System.out.println("\nOption [5] selected! - Change Assigned Project Title.");
						if(assigned){
							new NewChangeTitleRequest(this);
						}else{
							System.out.println("You are not assigned to a project!\n");
						}
						break;
		
					case 6: 
						System.out.println("\nOption [6] selected! - View All Requests");
						new ViewOutgoingRequestsHistory(this);
						break;				
		
					case 0: 
						System.out.println("Option [0] selected! - Exit Program\n");
						break;
		
					default:
						throw new InvalidInputException(choice);
				}
		}
	}	

	private void registerProject() throws InvalidInputException{
		ViewAvailableProjects projs = new ViewAvailableProjects(this);

		if (this.numRegisteredReq==1){
			System.out.println("You've already sent a request to register a project");
		}	
		else{
			// View Projects
			if(projs.projects.size()!=0){
				System.out.printf("Select Project to register: ");
				int projID = sc.nextInt();
				
				if(projs.projects.contains(projID)){
					FYPCoordinatorDB FYPDB = new FYPCoordinatorDB();
					new NewRequest(RequestType.REGISTERPROJECT, this, FYPDB.findInstance(), projID);
					this.numRegisteredReq+=1;
				}else{
					throw new InvalidInputException(projID);
				}
			}
		}
	}

	private void deregisterProject() throws InvalidInputException{
		// View Projects
		handleInvalidInput handler = new handleInvalidInput();
		ViewPersonalProjects projs = new ViewPersonalProjects(this);

		if(projs.projects.size()!=0){
			int choice;

			// header
			System.out.println("Deregister this project?");
			System.out.println("[1] Yes");
			System.out.println("[0] No");

			// getinput
			try{
				choice = sc.nextInt();
				switch(choice){
					case 1:
						FYPCoordinatorDB FYPDB = new FYPCoordinatorDB();
						new NewRequest(RequestType.DEREGISTERPROJECT, this, FYPDB.findInstance(), projs.projects.get(0));

					case 0:
						break;

					default: 
						throw new InvalidInputException(choice);
				}
			}catch(InvalidInputException e){
				handler.handleInvalidInputException(e);
			}catch(InputMismatchException e){
				handler.handleInputMismatchException(e);
			}	
		}
	}

	private void changeTitle() throws InvalidInputException{
		ViewPersonalProjects projs = new ViewPersonalProjects(this);
		// View Projects
		if(projs.projects.size()!=0){
			System.out.printf("Select Assigned Project to change title: ");
			int projID = super.sc.nextInt();
			
			if(projs.projects.contains(projID)){
				new NewRequest(RequestType.CHANGETITLE, this, projDB.findInstance(projID).getSupervisor(), projID);
			}else{
				throw new InvalidInputException(projID);
			}
		}
	}

	private void viewAllRequests(){
		new ViewOutgoingRequestsHistory(this);
	}
}