package Requests.Request;
import Projects.Project.Project;
import Projects.Project.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.User.User;

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
                approve();
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
