package Entity.RequestClass.RequestSubClass;
import Boundaries.Request.CreateRequestInterface;
import Entity.DatabaseClass.ProjectDB;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.Student;
import Entity.UserClass.UserDetails.User;

public class RegisterProjectRequest extends Request implements CreateRequestInterface{

    private ProjectDB projDB = new ProjectDB(); 
    
    public RegisterProjectRequest(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.REGISTERPROJECT, projectID);
    }

    @Override
    public Request createRequest() {

        Project selectedProject = projDB.findInstance(getProjectID());

        selectedProject.setProjectStatus(ProjectStatus.RESERVED);
        selectedProject.setStudent((Student) getFromUser());
        System.out.printf("Project [%d]: %s has been reserved\n", selectedProject.getProjectID(), selectedProject.getProjectTitle());

        projDB.exportDB();
        return this;
    }
}
