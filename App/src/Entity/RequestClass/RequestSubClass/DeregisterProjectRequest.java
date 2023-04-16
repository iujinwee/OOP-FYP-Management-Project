package Entity.RequestClass.RequestSubClass;
import Boundaries.Request.CreateRequestInterface;
import Entity.DatabaseClass.ProjectDB;
import Entity.ProjectClass.Project;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;

public class DeregisterProjectRequest extends Request implements CreateRequestInterface{
    
    private ProjectDB projDB = new ProjectDB();

    /**
	 * Deregister Project Request Constructor.
	 * @param requestID Unique ID of Request Object
	 * @param projectID Unique ID of Project Object
	 * @param fromUser User Object request is made from
     * @param toUser User Object request is made to
	 */
    public DeregisterProjectRequest(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.DEREGISTERPROJECT, projectID);
    }
    
    /** 
     * @return Request
     */
    @Override
    public Request createRequest() {
        
        Project selectedProject = projDB.findInstance(super.getProjectID());

        System.out.printf("Request to deregister [Project %d: %s] has been sent.\n\n", selectedProject.getProjectID(), selectedProject.getProjectTitle());

        projDB.exportDB();
        return this;
    }

}
