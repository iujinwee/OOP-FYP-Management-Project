package Requests.RequestClasses;
import Database.ProjectDB;
import Projects.Project;
import Projects.ProjectStatus;
import Requests.Request;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.*;
import Users.UserDetails.*;;

public class RegisterProjectRequest extends Request implements CreateRequestInterface{

    private ProjectDB projDB = new ProjectDB(); 
    
    public RegisterProjectRequest(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.REGISTERPROJECT, projectID);
    }

    @Override
    public Request createRequest() {

        Project selectedProject = projDB.findInstance(getProjectID());

        selectedProject.setProjectStatus(ProjectStatus.RESERVED);
        System.out.printf("Project [%d]: %s has been reserved\n", selectedProject.getProjectID(), selectedProject.getProjectTitle());

        projDB.exportDB();
        return this;
    }
}
