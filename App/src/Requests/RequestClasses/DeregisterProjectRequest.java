package Requests.RequestClasses;
import Database.ProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Requests.Request;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.UserDetails.*;;

public class DeregisterProjectRequest extends Request implements CreateRequestInterface{
    
    private ProjectDB projDB = new ProjectDB();

    public DeregisterProjectRequest(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.DEREGISTERPROJECT, projectID);
    }
    @Override
    public Request createRequest() {
        
        Project selectedProject = projDB.findInstance(super.getProjectID());

        selectedProject.setProjectStatus(ProjectStatus.AVAILABLE);
        selectedProject.addRejected(getfromUserID());
        System.out.printf("Project [%d]: %s has been deregistered\n", selectedProject.getProjectID(), selectedProject.getProjectTitle());

        projDB.exportDB();
        return this;
    }

}
