package Entity.RequestClass.RequestSubClass;

import Boundaries.Request.CreateRequestInterface;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;

public class ChangeTitleRequest extends Request implements CreateRequestInterface {

    private String newTitle;

    public ChangeTitleRequest(int requestID, int projectID, User fromUser, User toUser, String newTitle) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGETITLE, projectID);
        this.newTitle = newTitle;
    }
    
    /** 
     * @return Request
     */
    @Override
    public Request createRequest() {
        super.setNewTitle(newTitle);
        System.out.printf("Request to change title to [%s] has been sent.\n", newTitle);
        return this;
    }
}
