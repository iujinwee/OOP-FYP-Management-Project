package Requests;
import Projects.ProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.FYP_Coordinator;
import Users.UserDetails.*;

public class ChangeTitle extends Request{
    
    private String newTitle;
    private int requestID;

    public ChangeTitle(int requestID, String newTitle) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGETITLE, projectID)
        this.newTitle = newTitle;
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                ProjectDB projDB = new ProjectDB();
                projDB.loadDB();
                projDB.findInstance(projectID).setTitle(newTitle);
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
