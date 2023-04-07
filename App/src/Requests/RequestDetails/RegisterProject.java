package Requests.Request;
import Projects.Project.Project;
import Projects.Project.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.User.User;

public class RegisterProject extends Request{

    private int projectID;

    public RegisterProject(int requestID, int projectID) {
        super(requestID);
        setRequestType(RequestType.REGISTERPROJECT);
        setToUser(/*FYP_Coordinator*/);
        this.projectID = projectID;
        //scan through project list for project with projectID
        //set project status to RESERVED
    }

    public void approve() {
        //scan through project list for project with projectID
        //set project status to ALLOCATED

        //allocate project to student

        setRequestStatus(RequestStatus.APPROVED);
        throw new UnsupportedOperationException();
    }

    public void reject() {
        setRequestStatus(RequestStatus.REJECTED);
        //scan through project list for project with projectID
        //set project status to AVAILABLE
        throw new UnsupportedOperationException();
    }
    
}
