package Entity.RequestClass.RequestSubClass;
import java.util.Scanner;

import Boundaries.Request.CreateRequestInterface;
import Entity.DatabaseClass.SupervisorDB;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public class ChangeSupervisorRequest extends Request implements CreateRequestInterface{
    private SupervisorDB supDB = new SupervisorDB();
    private String newSupervisor;

    public ChangeSupervisorRequest(int requestID, int projectID, User fromUser, User toUser, String newSupervisor) {
        super(requestID, fromUser, toUser, RequestStatus.PENDING, RequestType.CHANGESUPERVISOR, projectID);
        this.newSupervisor = newSupervisor;

    }    
    
    @Override
    public Request createRequest() {
        
        // handleInvalidInput handler = new handleInvalidInput(3);
        // supDB.view(); // View Supervisor DB

        // Scanner sc = new Scanner(System.in);
        
        // while(handler.checkAttempts()){
        //     try{
        //         System.out.println("Key in ID of new supervisor:");
        //         newSupervisor = sc.next();

        //         if(supDB.findInstance(newSupervisor)!=null){
        //             setNewSupervisor(newSupervisor);
        //             System.out.printf("Request to change supervisor to [%s] has been sent.\n", supDB.findInstance(newSupervisor).getName());
        //             break;
        //         }else{
        //             throw new InvalidInputException(newSupervisor);
        //         }
        //     }catch(InvalidInputException e){
        //         handler.handleInvalidInputException(e);
        //     }
        // }

        setNewSupervisor(newSupervisor);

        return this;
    }

}
