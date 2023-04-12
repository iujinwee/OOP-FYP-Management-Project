package Requests.RequestClasses;
import java.util.Scanner;

import Database.RequestDB;
import Database.SupervisorDB;
import Requests.Request;
import Requests.RequestStatus;
import Requests.RequestType;
import Users.UserDetails.*;

public class ChangeSupervisorRequest extends Request implements CreateRequestInterface{
    private SupervisorDB supDB = new SupervisorDB();
    private String newSupervisor;

    public ChangeSupervisorRequest(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGESUPERVISOR, projectID);
    }    
    
    @Override
    public Request createRequest() {
        
        supDB.view(); // View Supervisor DB

        Scanner sc = new Scanner(System.in);
        System.out.println("Select the supervisor to change to:");
        newSupervisor = sc.next();

        super.setNewSupervisor(newSupervisor);
        sc.close();
        return this;
    }

}
