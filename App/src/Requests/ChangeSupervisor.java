package Requests;
import Projects.ProjectDB;
import Database.SupervisorDB;
import Projects.Project;
import Projects.ProjectStatus;
import Users.Student;
import Users.Supervisor;
import Users.FYP_Coordinator;
import Users.UserDetails.*;;

public class ChangeSupervisor extends Request{

    private int newSupervisor;

    public ChangeSupervisor(int requestID, int newSupervisor, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGESUPERVISOR, projectID);
        this.newSupervisor = newSupervisor;
    }

    public void enactRequest(int choice){
        switch(choice){
            case 1:
                ProjectDB projDB = new ProjectDB();
                Project project = projDB.findInstance(getProjectID());
                SupervisorDB supDB = new SupervisorDB();
                Supervisor newSup = supDB.findInstance(this.newSupervisor);
                project.setSupervisor(newSup);
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
