package Requests.RequestClasses;

import java.util.Scanner;

import Requests.Request;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.UserDetails.*;

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
        sc.close();
        return this;
    }
}
