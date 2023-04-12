package Requests.RequestClasses;
import Database.ProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Requests.Request;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.UserDetails.*;;

public class DeregisterProjectRequest extends Request{
    
    private ProjectDB projDB = new ProjectDB();

    public DeregisterProjectRequest(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.DEREGISTERPROJECT, projectID);

        Project selectedProject = projDB.findInstance(projectID);

        selectedProject.setProjectStatus(ProjectStatus.AVAILABLE);
        selectedProject.addRejected(getfromUserID());
        System.out.printf("Project [%d]: %s has been deregistered\n", selectedProject.getProjectID(), selectedProject.getProjectTitle());

        projDB.exportDB();
    }

    // public void enactRequest(int choice){
    //     switch(choice){
    //         case 1:
    //             Project selectedProject = projDB.findInstance(getProjectID());
    //             selectedProject.setProjectStatus(ProjectStatus.AVAILABLE);
    //             projDB.exportDB();
    //             setRequestStatus(RequestStatus.APPROVED);
    //             break;
    //         case 0:
    //             projDB.findInstance(getProjectID()).addRejected(getFromUser().getUserID());
    //             projDB.exportDB();
    //             setRequestStatus(RequestStatus.REJECTED);
    //             break;
    //         default:
    //             System.out.println("Invalid choice");
    //             break;
    //     }
    // }
}
