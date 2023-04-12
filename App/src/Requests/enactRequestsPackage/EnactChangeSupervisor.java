package Requests.enactRequestsPackage;

import Projects.ProjectClasses.ChangeProjectSupervisor;
import Requests.RequestStatus;

public class EnactChangeSupervisor extends EnactRequest {

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