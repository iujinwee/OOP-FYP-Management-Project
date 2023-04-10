package Requests.Request;
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
        //scan through project list for project with projectID
        //set project status to RESERVED
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
