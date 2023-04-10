package Requests;
import Projects.Project.Project;
import Projects.Project.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.User.User;

public class ChangeTitle extends Request{
    
    String newTitle;

    public ChangeTitle(int requestID, String newTitle) {
        super(requestID);
        setRequestType(RequestType.CHANGETITLE);
        setToUser(belongs.getSupervisor());
        this.newTitle = newTitle;
    }

    public void approve() {
        modifies.setProjectTitle(newTitle);
        setRequestStatus(RequestStatus.APPROVED);
        throw new UnsupportedOperationException();
    }

    public void reject() {
        setRequestStatus(RequestStatus.REJECTED);
        throw new UnsupportedOperationException();
    }
}
