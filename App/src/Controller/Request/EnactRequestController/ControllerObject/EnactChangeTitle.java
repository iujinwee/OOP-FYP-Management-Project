package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Request.EnactRequestController.EnactRequestController;
import Entity.RequestClass.RequestStatus;
import Controller.Project.ModifyProjectController.ControllerObject.ChangeProjectTitle;

public class EnactChangeTitle extends EnactRequestController {

    public EnactChangeTitle(int reqID){
        super(reqID);
    }

    @Override
    public void enactRequest(int choice){
        switch(choice){
            // Approve
            case 1:
                new ChangeProjectTitle(request.getProjectID(), request.getNewTitle());
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