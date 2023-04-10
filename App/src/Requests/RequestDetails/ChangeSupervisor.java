package Requests.Request;
import Projects.ProjectDB;
import Projects.Project.Project;
import Projects.Project.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.User.User;

public class ChangeSupervisor extends Request{

    private int newSupervisor;
    private int projectID;
    private int requestID;

    public ChangeSupervisor(int requestID, int newSupervisor, int projectID) {
        super(requestID, fromUser, FYP_Coordinator, RequestStatus.PENDING, RequestType.CHANGESUPERVISOR, projectID);
        this.newSupervisor = newSupervisor;
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
