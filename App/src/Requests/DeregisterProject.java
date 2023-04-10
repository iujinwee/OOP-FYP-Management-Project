package Requests;
import Projects.ProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.FYP_Coordinator;
import Users.UserDetails.*;;

public class DeregisterProject extends Request{
    
    private int projectID;
    private int requestID;

    public DeregisterProject(int requestID, int projectID) {
        super(requestID, fromUser, FYP_Coordinator, RequestStatus.PENDING, RequestType.DEREGISTERPROJECT, projectID);
        setRequestType(RequestType.DEREGISTERPROJECT);
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                ProjectDB projDB = new ProjectDB();
                projDB.loadDB();
                projDB.findInstance(projectID).setProjectStatus(Projects.ProjectDetails.ProjectStatus.AVAILABLE);
                projDB.exportDB();
                setRequestStatus(RequestStatus.APPROVED);
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
