package Requests.Request;
import Projects.ProjectDB;
import Projects.Project.Project;
import Projects.Project.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.User.User;

public class RegisterProject extends Request{

    private int projectID;
    private int requestID;

    public RegisterProject(int requestID, int projectID) {
        super(requestID, fromUser, FYP_Coordinator, RequestStatus.PENDING, RequestType.REGISTERPROJECT, projectID);
        this.projectID = projectID;
        ProjectDB projDB = new ProjectDB();
        projDB.loadDB();
        projDB.findInstance(projectID).setProjectStatus(Projects.ProjectDetails.ProjectStatus.RESERVED);
        projDB.exportDB();
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                ProjectDB projDB = new ProjectDB();
                projDB.loadDB();
                projDB.findInstance(projectID).setProjectStatus(Projects.ProjectDetails.ProjectStatus.ALLOCATED);
                break;
            case 2:
                setRequestStatus(RequestStatus.REJECTED);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    
}
