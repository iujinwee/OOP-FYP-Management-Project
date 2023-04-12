package Requests.enactRequestsPackage;

import Projects.ProjectClasses.ChangeProjectSupervisor;
import Projects.ProjectClasses.DeregisterProject;
import Requests.RequestStatus;
import Users.Student;

public class EnactDeregisterProject extends EnactRequest {

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