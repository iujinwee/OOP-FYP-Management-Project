package Requests.RequestClasses;

import java.util.Scanner;

import Database.ProjectDB;
import Requests.Request;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.UserDetails.*;

public class ChangeTitleRequest extends Request implements EnactRequestInterface{

    public ChangeTitleRequest(int requestID, String newTitle, User fromUser, User toUser, int projectID) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGETITLE, projectID);
        super.setNewTitle(newTitle);
    }
}
