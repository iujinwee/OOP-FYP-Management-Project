package Requests;
import Database.ProjectDB;
import Projects.ProjectStatus;
import Users.*;
import Users.UserDetails.*;;

public class RegisterProject extends Request{


    public RegisterProject(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.REGISTERPROJECT, projectID);
        ProjectDB projDB = new ProjectDB();
        (projDB.findInstance(projectID)).setProjectStatus(ProjectStatus.RESERVED);
        projDB.exportDB();
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                ProjectDB projDB = new ProjectDB();

                (projDB.findInstance(super.getProjectID())).setProjectStatus(ProjectStatus.ALLOCATED);
                (projDB.findInstance(super.getProjectID())).setStudent((Student)super.getFromUser());
                
                projDB.exportDB();
                break;

            case 0:
                ProjectDB projDB0 = new ProjectDB();
                (projDB0.findInstance(getProjectID())).setProjectStatus(ProjectStatus.AVAILABLE);
                projDB0.exportDB();
                setRequestStatus(RequestStatus.REJECTED);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    
}
