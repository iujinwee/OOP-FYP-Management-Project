package Requests.RequestClasses;
import Database.ProjectDB;
import Requests.Request;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.UserDetails.*;

public class ChangeTitleRequest extends Request implements EnactRequestInterface{

    public ChangeTitleRequest(int requestID, String newTitle, User fromUser, User toUser, int projectID) {
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
