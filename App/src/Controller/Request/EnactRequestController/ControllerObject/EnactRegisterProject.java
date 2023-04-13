package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Request.EnactRequestController.EnactRequestController;
import Controller.Project.ModifyProjectController.ControllerObject.RegisterProject;
import Entity.RequestClass.RequestStatus;
import Entity.UserClass.Student;

public class EnactRegisterProject extends EnactRequestController {

    public EnactRegisterProject(int reqID){
        super(reqID);
    }

    @Override
    public void enactRequest(int choice){
        switch(choice){
            // Approve
            case 1:
                new RegisterProject(request.getProjectID(), (Student) request.getFromUser());
                request.setRequestStatus(RequestStatus.APPROVED);
                break;

            // Reject
            case 0:
                request.setRequestStatus(RequestStatus.REJECTED);
                break;
                
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}