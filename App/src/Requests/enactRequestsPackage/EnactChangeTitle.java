package Requests.enactRequestsPackage;

import Projects.ProjectClasses.ChangeProjectTitle;
import Requests.RequestStatus;

public class EnactChangeTitle extends EnactRequest {

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