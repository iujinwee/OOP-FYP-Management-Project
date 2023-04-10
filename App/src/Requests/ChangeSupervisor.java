package Requests;
import Database.ProjectDB;
import Database.SupervisorDB;
import Projects.Project;
import Users.UserDetails.*;;

public class ChangeSupervisor extends Request{

    public ChangeSupervisor(int requestID, String newSupervisor, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGESUPERVISOR, projectID);
        super.setNewSupervisor(newSupervisor);
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                ProjectDB projDB = new ProjectDB();
                SupervisorDB supDB = new SupervisorDB();

                ((Project) projDB.findInstance(getProjectID())).setSupervisor(supDB.findInstance(super.getNewSupervisor()));
                
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
