package Entity.RequestClass.RequestSubClass;

import Boundaries.Request.CreateRequestInterface;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;

public class ChangeSupervisorRequest extends Request implements CreateRequestInterface{
    private String newSupervisor;

    /**
	 * Change Supervisor Request Constructor.
	 * @param requestID Unique ID of Request Object
	 * @param projectID Unique ID of Project Object
	 * @param fromUser User Object request is made from
     * @param toUser User Object request is made to
     * @param newSupervisor New Supervisor Object
	 */
    public ChangeSupervisorRequest(int requestID, int projectID, User fromUser, User toUser, String newSupervisor) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGESUPERVISOR, projectID);
        this.newSupervisor = newSupervisor;
    }    
    
    
    /** 
     * Method to create a new request.
     * @return Request
     */
    @Override
    public Request createRequest() {

        setNewSupervisor(newSupervisor);
        System.out.printf("Request to change supervisor to [%s] has been sent.\n\n", newSupervisor);

        return this;
    }

}
