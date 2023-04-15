package Boundaries.Menu.Classes;

import Boundaries.Project.Classes.ViewAvailableProjects;
import Boundaries.Project.Classes.ViewPersonalProjects;
import Controller.Account.ModifyAccountDBController.ChangePassword;
import Controller.Menu.UserMenuController;
import Controller.Request.CreateRequestController.ControllerObject.NewChangeTitleRequest;
import Controller.Request.CreateRequestController.ControllerObject.NewDeregisterRequest;
import Controller.Request.CreateRequestController.ControllerObject.NewRegisterRequest;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewOutgoingRequestsHistory;
import Entity.DatabaseClass.RequestDB;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.UserClass.Student;
import Exceptions.InvalidInputException;


public class StudentMenu extends UserMenuController {
    
    private Student student;
    private int pendingCount; 

    /**
	 * Student Menu Constructor.
	 * @param student Student Object
	 */
    public StudentMenu(Student student) {
        this.student = student;
        
        handleException();
    }

    @Override
    public void viewUserMenu() {
        System.out.println("=============  STUDENT MENU  ==============");
		System.out.println("[1] View Available Projects.");
		System.out.println("[2] View Registered Project.");
		System.out.println("[3] Register Project.");
		System.out.println("[4] Deregister Project.");
		System.out.println("[5] Change Assigned Project Title.");
		System.out.println("[6] View Request Status and History.");
		System.out.println("[7] Change Password.");
        System.out.println("[8] Log Out.");
		System.out.println("[0] Exit Program.");
    }

    
    /** 
     * @throws InvalidInputException
     */
    @Override
    public void getInput() throws InvalidInputException {

        int choice = -1;
        while (choice != 0 && choice != 8){	

            this.pendingCount  = checkPending();
            
			// Show User Menu
			viewUserMenu();

			System.out.printf("\nEnter Option: ");
			choice = sc.nextInt();

            switch(choice){
                case 1: 
                    System.out.println("\nOption [1] selected! - View Available Projects");
                    if(!student.getAssigned()){
                        new ViewAvailableProjects(student);
                    }else{
                        System.out.println("You are already assigned to a project!\n");
                    }
                    break;
    
                case 2: 
                    System.out.println("\nOption [2] selected! - View Registered Project.");
                    if(student.getAssigned()){
                        new ViewPersonalProjects(student);
                    }else{
                        System.out.println("You are not assigned to a project!\n");
                    }
                    break;
    
                case 3:
                    System.out.println("\nOption [3] selected! - Register Project.");

                    if(student.getAssigned()){
                        System.out.println("You are already assigned to a project!\n");
                    }else if(pendingCount!=0){
                        System.out.println("You already have a pending request!\n");   
                    }else{
                        new NewRegisterRequest(student);
                    }
                    break;
    
                case 4:	
                    System.out.println("\nOption [4] selected! - Deregister Project.");

                    if(!student.getAssigned()){
                        System.out.println("You are not assigned to a project!\n");
                    }else if(pendingCount!=0){
                        System.out.println("You already have a pending request!\n");   
                    }else{
                        new NewDeregisterRequest(student);
                    }
                    break;

                case 5:
                    System.out.println("\nOption [5] selected! - Change Assigned Project Title.");

                    if(!student.getAssigned()){
                        System.out.println("You are not assigned to a project!\n");
                    }else if(pendingCount!=0){
                        System.out.println("You already have a pending request!\n");   
                    }else{
                        new NewChangeTitleRequest(student);
                    }
                    break;
    
                case 6: 
                    System.out.println("\nOption [6] selected! - View Request Status and History.");
                    new ViewOutgoingRequestsHistory(student);
                    break;				
                    
                case 7:
                    System.out.println("\nOption [7] selected! - Change Password");
                    new ChangePassword(student.getUserID());
                    break;
                
                case 8:
                    System.out.println("\nOption [8] selected! - Log Out\n");
                    new WelcomePage();
                    break;
            
                case 0: 
                    System.out.println("\nOption [0] selected! - Exit Program");
                    break;
    
                default:
                    throw new InvalidInputException(choice);
            }
            
        }
    }

    private int checkPending(){
        RequestDB d = new RequestDB();
        int count = 0; 

        for (Object o : d.objectDB){
            Request r = (Request)o;
            boolean pend = r.getRequestStatus().compareTo(RequestStatus.PENDING)==0;
            boolean own = r.getFromUser().getUserID().compareTo(student.getUserID())==0;

            if(pend && own){
                count++;
            }
        }
        return count; 
    }
        
}
