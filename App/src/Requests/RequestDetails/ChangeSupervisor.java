package Requests.Request;
import Projects.ProjectDB;
import Projects.Project.Project;
import Projects.Project.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.User.User;

public class ChangeSupervisor extends Request{

    private int newSupervisorID, projectID;

    public ChangeSupervisor(int requestID, int newSupervisorID, int projectID) {
        super(requestID);
        setRequestType(RequestType.CHANGESUPERVISOR);
        setToUser(/*FYP_Coordinator */);
        this.newSupervisorID = newSupervisorID;
        this.projectID = projectID;
    }

    public void enactRequest(Request req){
        ProjectDB projdb = new ProjectDB();
        projdb.setSupervisor(req.getTitle());
        projdb.exportFile();
    }

    public void approve() {
        //scan through project list for project with projectID
        //scan through supervisor list for supervisor with newSupervisorID
        //set project supervisor to newSupervisor
        setRequestStatus(RequestStatus.APPROVED);
        throw new UnsupportedOperationException();
    }

    public void reject() {
        setRequestStatus(RequestStatus.REJECTED);
        throw new UnsupportedOperationException();
    }
    
}
