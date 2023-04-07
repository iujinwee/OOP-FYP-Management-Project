package Requests.Request;
import Projects.Project.Project;
import Projects.Project.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.User.User;

public class DeregisterProject extends Request{
    
    private int projectID;

    public DeregisterProject(int requestID) {
        super(requestID);
        setRequestType(RequestType.DEREGISTERPROJECT);
        setToUser(/*FYP_Coordinator*/);
        projectID = modifies.getProjectID();
    }

    public void approve() {
        modifies.setProjectStatus(ProjectStatus.AVAILABLE);
        modifies.setStudent(null);
        //does student have attribute projectID?
        //if yes, set to null
        //not sure how to make it unavailable for this particular student
        //but available for other students
        //maybe add a new attribute to student class
        //called "unavailableProjects" or something
        //and add projectID to that list

        setRequestStatus(RequestStatus.APPROVED);
        throw new UnsupportedOperationException();
    }

    public void reject() {
        setRequestStatus(RequestStatus.REJECTED);
        throw new UnsupportedOperationException();
    }
    
}
