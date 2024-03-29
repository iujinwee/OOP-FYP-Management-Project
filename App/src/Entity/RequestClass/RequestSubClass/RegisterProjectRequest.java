package Entity.RequestClass.RequestSubClass;
import Boundaries.Request.CreateRequestInterface;
import Entity.DatabaseClass.ProjectDB;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;

public class RegisterProjectRequest extends Request implements CreateRequestInterface{

    private ProjectDB projDB = new ProjectDB(); 
    
    /**
	 * Register Project Request Constructor.
	 * @param requestID Unique ID of Request Object
	 * @param projectID Unique ID of Project Object
	 * @param fromUser User Object request is made from
     * @param toUser User Object request is made to
	 */
    public RegisterProjectRequest(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.REGISTERPROJECT, projectID);
    }

    
    /** 
     * @return Request
     */
    @Override
    public Request createRequest() {

        Project selectedProject = projDB.findInstance(getProjectID());

        selectedProject.setProjectStatus(ProjectStatus.RESERVED);
        System.out.printf("Project [%d]: %s has been reserved.\n\n", selectedProject.getProjectID(), selectedProject.getProjectTitle());

        projDB.exportDB();
        return this;
    }
}
