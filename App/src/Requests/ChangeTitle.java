package Requests;
import Database.ProjectDB;
import Projects.Project;
import Users.UserDetails.*;

public class ChangeTitle extends Request implements EnactRequestInterface{

    public ChangeTitle(int requestID, String newTitle, User fromUser, User toUser, int projectID) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGETITLE, projectID);
        super.setNewTitle(newTitle);
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                ProjectDB projDB = new ProjectDB();
                projDB.findInstance(getProjectID()).setProjectTitle(super.getNewTitle());

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
