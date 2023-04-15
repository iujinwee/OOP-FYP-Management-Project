package Entity.RequestClass.RequestSubClass;

import Boundaries.Request.CreateRequestInterface;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;

public class ChangeSupervisorRequest extends Request implements CreateRequestInterface{
    private String newSupervisor;

    public ChangeSupervisorRequest(int requestID, int projectID, User fromUser, User toUser, String newSupervisor) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGESUPERVISOR, projectID);
        this.newSupervisor = newSupervisor;
    }    
    
    @Override
    public Request createRequest() {

        setNewSupervisor(newSupervisor);
        System.out.printf("Request to change supervisor to [%s] has been sent.\n\n", newSupervisor);

        return this;
    }

}
