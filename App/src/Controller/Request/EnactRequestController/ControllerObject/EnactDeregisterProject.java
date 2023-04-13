package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Request.EnactRequestController.EnactRequestController;
import Controller.Project.ModifyProjectController.ControllerObject.DeregisterProject;
import Entity.RequestClass.RequestStatus;
import Entity.UserClass.Student;

public class EnactDeregisterProject extends EnactRequestController {

    public EnactDeregisterProject(int reqID){
        super(reqID);
    }

    @Override
    public void enactRequest(int choice){
        switch(choice){
            // Approve
            case 1:
                Student dereg = (Student) request.getFromUser();
                new DeregisterProject(request.getProjectID(), dereg);
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