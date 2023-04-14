package Entity.RequestClass.RequestSubClass;
import Boundaries.Request.CreateRequestInterface;
import Entity.DatabaseClass.ProjectDB;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;

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