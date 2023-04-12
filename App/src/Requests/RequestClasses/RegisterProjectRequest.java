package Requests.RequestClasses;
import Database.ProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Requests.Request;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.*;
import Users.UserDetails.*;;

public class RegisterProjectRequest extends Request{

    private ProjectDB projDB = new ProjectDB(); 
    
    public RegisterProjectRequest(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.REGISTERPROJECT, projectID);

        Project selectedProject = projDB.findInstance(projectID);

        selectedProject.setProjectStatus(ProjectStatus.RESERVED);
        selectedProject.setStudent((Student) fromUser);
        System.out.printf("Project [%d]: %s has been reserved\n", selectedProject.getProjectID(), selectedProject.getProjectTitle());

        projDB.exportDB();
    }

    // public void enactRequest(int choice){
    //     switch(choice){
    //         case 1:
    //             projDB.findInstance(super.getProjectID()).setProjectStatus(ProjectStatus.ALLOCATED);
    //             projDB.findInstance(super.getProjectID()).setStudent((Student)super.getFromUser());
                
    //             projDB.exportDB();
    //             break;

    //         case 0:
    //             projDB.findInstance(getProjectID()).setProjectStatus(ProjectStatus.AVAILABLE);
    //             setRequestStatus(RequestStatus.REJECTED);
    //             projDB.exportDB();
    //             break;
    //         default:
    //             System.out.println("Invalid choice");
    //             break;
    //     }
    // }
    
}
