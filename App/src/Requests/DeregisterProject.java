package Requests;
import Database.ProjectDB;
import Projects.ProjectStatus;
import Users.UserDetails.*;;

public class DeregisterProject extends Request{
    
    private ProjectDB projDB = new ProjectDB();

    public DeregisterProject(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.DEREGISTERPROJECT, projectID);
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                projDB.findInstance(getProjectID()).setProjectStatus(ProjectStatus.AVAILABLE);
                projDB.exportDB();
                setRequestStatus(RequestStatus.APPROVED);
                break;
            case 0:
                projDB.findInstance(getProjectID()).addRejected(getFromUser().getUserID());
                projDB.exportDB();
                setRequestStatus(RequestStatus.REJECTED);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
