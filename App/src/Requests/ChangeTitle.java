package Requests;
import Database.ProjectDB;
import Users.UserDetails.*;

public class ChangeTitle extends Request{

    public ChangeTitle(int requestID, String newTitle, User fromUser, User toUser, int projectID) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGETITLE, projectID);
        super.setNewTitle(newTitle);
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                ProjectDB projDB = new ProjectDB();
                (projDB.findInstance(super.getProjectID())).setProjectTitle(super.getNewTitle());
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
