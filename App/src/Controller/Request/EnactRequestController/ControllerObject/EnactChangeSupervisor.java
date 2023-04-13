package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Project.ModifyProjectController.ControllerObject.ChangeProjectSupervisor;
import Controller.Request.EnactRequestController.EnactRequestController;
import Entity.RequestClass.RequestStatus;

public class EnactChangeSupervisor extends EnactRequestController {

    public EnactChangeSupervisor(int reqID){
        super(reqID);
    }

    @Override
    public void enactRequest(int choice){
        switch(choice){
            // Approve
            case 1:
                new ChangeProjectSupervisor(request.getProjectID(), request.getNewSupervisor());
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