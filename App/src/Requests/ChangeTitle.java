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

    public ChangeTitle(int requestID, String newTitle, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGETITLE, toUser.getprojectID());
        this.newTitle = newTitle;
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                ProjectDB projDB = new ProjectDB();
                Project project = projDB.findInstance(getProjectID());
                project.setProjectTitle(newTitle);
                projDB.exportDB();
                setRequestStatus(RequestStatus.APPROVED);
                break;
            case 0:
                setRequestStatus(RequestStatus.REJECTED);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
