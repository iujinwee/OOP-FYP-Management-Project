package Requests;
import Projects.ProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.FYP_Coordinator;
import Users.UserDetails.*;;

public class RegisterProject extends Request{


    public RegisterProject(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.REGISTERPROJECT, projectID);
        this.projectID = projectID;
        ProjectDB projDB = new ProjectDB();
        projDB.findInstance(projectID).setProjectStatus(ProjectStatus.RESERVED);
        projDB.exportDB();
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                ProjectDB projDB = new ProjectDB();
                (projDB.findInstance(getProjectID())).setProjectStatus(ProjectStatus.ALLOCATED);
                projDB.exportDB();
                break;
            case 2:
                ProjectDB projDB = new ProjectDB();
                (projDB.findInstance(getProjectID())).setProjectStatus(ProjectStatus.AVAILABLE);
                projDB.exportDB();
                setRequestStatus(RequestStatus.REJECTED);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    
}
