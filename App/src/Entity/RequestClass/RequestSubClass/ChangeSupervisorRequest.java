package Entity.RequestClass.RequestSubClass;
import java.util.Scanner;

import Boundaries.Request.CreateRequestInterface;
import Entity.DatabaseClass.SupervisorDB;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;

public class ChangeSupervisorRequest extends Request implements CreateRequestInterface{
    private SupervisorDB supDB = new SupervisorDB();
    private String newSupervisor;

    public ChangeSupervisorRequest(int requestID, int projectID, User fromUser, User toUser, String newSupervisor) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGESUPERVISOR, projectID);
        this.newSupervisor = newSupervisor;

    }    
    
    @Override
    public Request createRequest() {

        setNewSupervisor(newSupervisor);

        return this;
    }

}
