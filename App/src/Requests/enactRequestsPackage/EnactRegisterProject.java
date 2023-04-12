package Requests.enactRequestsPackage;

import Projects.ProjectClasses.ChangeProjectSupervisor;
import Projects.ProjectClasses.RegisterProject;
import Projects.Project;
import Requests.RequestStatus;
import Users.Student;

public class EnactRegisterProject extends EnactRequest {

    public EnactRegisterProject(int reqID){
        super(reqID);
    }

    @Override
    public void enactRequest(int choice){
        switch(choice){
            // Approve
            case 1:
                new RegisterProject(request.getProjectID(), (Student) request.getFromUser());
                Project selectedProject = projDB.findInstance(request.getProjectID());
                selectedProject.setStudent((Student)request.getFromUser());
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