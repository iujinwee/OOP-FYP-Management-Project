package Controller.User.UserMenuController;

import Controller.Account.ModifyAccountDBController.ChangePassword;
import Controller.Project.ViewProjectController.ControllerObject.ViewAvailableProjects;
import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Controller.Request.CreateRequestController.ControllerObject.NewChangeTitleRequest;
import Controller.Request.CreateRequestController.ControllerObject.NewDeregisterRequest;
import Controller.Request.CreateRequestController.ControllerObject.NewRegisterRequest;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewOutgoingRequestsHistory;
import Entity.UserClass.Student;
import Exceptions.InvalidInputException;


public class StudentMenu extends UserMenuController {
    
    private Student student;

    public StudentMenu(Student student) {
        this.student = student;

        handleException();
    }

    @Override
    public void viewUserMenu() {
        System.out.println("=============  STUDENT MENU  ==============");
		System.out.println("[1] Show Available Projects.");
		System.out.println("[2] Show Registered Project.");
		System.out.println("[3] Register Project.");
		System.out.println("[4] Deregister Project.");
		System.out.println("[5] Change Assigned Project Title.");
		System.out.println("[6] View Request Status and History.");
		System.out.println("[7] Change Password.");
		System.out.println("[0] Exit Program.");
    }

    @Override
    public void getInput() throws InvalidInputException {

        int choice = -1;
        while (choice != 0){	

			// Show User Menu
			viewUserMenu();

			System.out.printf("\nEnter Option: ");
			choice = sc.nextInt();

            switch(choice){
                case 1: 
                    System.out.println("\nOption [1] selected! - Show Available Projects");
                    if(!student.getAssigned()){
                        new ViewAvailableProjects(student);
                    }else{
                        System.out.println("You are already assigned to a project!\n");
                    }
                    break;
    
                case 2: 
                    System.out.println("\nOption [2] selected! - Show Registered Project.");
                    if(student.getAssigned()){
                        new ViewPersonalProjects(student);
                    }else{
                        System.out.println("You are not assigned to a project!\n");
                    }
                    break;
    
                case 3:
                    System.out.println("\nOption [3] selected! - Register Project.");
                    if(!student.getAssigned()){
                        new NewRegisterRequest(student);
                    }else{
                        System.out.println("You are already assigned to a project!\n");
                    }
                    break;
    
                case 4:	
                    System.out.println("\nOption [4] selected! - Deregister Project.");
                    if(student.getAssigned()){
                        new NewDeregisterRequest(student);
                    }else{
                        System.out.println("You are not assigned to a project!\n");
                    }
                    break;
    
                case 5:
                    System.out.println("\nOption [5] selected! - Change Assigned Project Title.");
                    if(student.getAssigned()){
                        new NewChangeTitleRequest(student);
                    }else{
                        System.out.println("You are not assigned to a project!\n");
                    }
                    break;
    
                case 6: 
                    System.out.println("\nOption [6] selected! - View All Requests");
                    new ViewOutgoingRequestsHistory(student);
                    break;				
                    
                case 7:
                    System.out.println("\nOption [7] selected! - Change Password");
                    new ChangePassword(student.getUserID());
                    break;
            
                case 0: 
                    System.out.println("\nOption [0] selected! - Exit Program");
                    break;
    
                default:
                    throw new InvalidInputException(choice);
            }
            
        }
    }
        
}
