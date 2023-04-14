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

    public ChangeSupervisorRequest(int requestID, int projectID, User fromUser, User toUser) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGESUPERVISOR, projectID);
    }    
    
    @Override
    public Request createRequest() {
        
        supDB.view(); // View Supervisor DB

        Scanner sc = new Scanner(System.in);
        System.out.println("Key in ID of new supervisor:");
        newSupervisor = sc.next();

        super.setNewSupervisor(newSupervisor);
        sc.close();
        return this;
    }

}
