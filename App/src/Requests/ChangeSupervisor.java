package Requests;
import Database.ProjectDB;
import Database.SupervisorDB;
import Users.UserDetails.*;

public class ChangeSupervisor extends Request implements EnactRequestInterface{
    private ProjectDB projDB = new ProjectDB();
    
    public ChangeSupervisor(int requestID, String newSupervisor, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGESUPERVISOR, projectID);
        super.setNewSupervisor(newSupervisor);
    }

    public void enactRequest(int choice){
        switch(choice){
            // Approve
            case 1:
                SupervisorDB supDB = new SupervisorDB();
                projDB.findInstance(getProjectID()).setSupervisor(supDB.findInstance(super.getNewSupervisor()))\;
                
                projDB.exportDB();
                setRequestStatus(RequestStatus.APPROVED);
                break;

            // Reject
            case 0:
                setRequestStatus(RequestStatus.REJECTED);
                break;
                
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    
}
