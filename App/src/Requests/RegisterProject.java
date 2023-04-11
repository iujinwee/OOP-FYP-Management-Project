package Requests;
import Database.ProjectDB;
import Projects.ProjectStatus;
import Users.*;
import Users.UserDetails.*;;

public class RegisterProject extends Request{

    private ProjectDB projDB = new ProjectDB(); 
    
    public RegisterProject(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.REGISTERPROJECT, projectID);
        projDB.findInstance(projectID).setProjectStatus(ProjectStatus.RESERVED);
        projDB.exportDB();
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                projDB.findInstance(super.getProjectID()).setProjectStatus(ProjectStatus.ALLOCATED);
                projDB.findInstance(super.getProjectID()).setStudent((Student)super.getFromUser());
                
                projDB.exportDB();
                break;

            case 0:
                projDB.findInstance(getProjectID()).setProjectStatus(ProjectStatus.AVAILABLE);
                setRequestStatus(RequestStatus.REJECTED);
                projDB.exportDB();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    
}
