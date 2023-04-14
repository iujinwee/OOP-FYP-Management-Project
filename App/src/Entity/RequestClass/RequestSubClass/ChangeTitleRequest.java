package Entity.RequestClass.RequestSubClass;

import java.util.Scanner;

import Boundaries.Request.CreateRequestInterface;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;

public class ChangeTitleRequest extends Request implements CreateRequestInterface {

    private String newTitle;

    public ChangeTitleRequest(int requestID, User fromUser, User toUser, int projectID) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGETITLE, projectID);
    }
    @Override
    public Request createRequest() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Input new project title:");
        newTitle = sc.next();

        super.setNewTitle(newTitle);
        return this;
    }
}
