package Requests;

import Projects.ProjectClasses.ChangeProjectSupervisor;
import Requests.RequestClasses.EnactRequestInterface;

public class enactChangeSupervisor extends ModifyRequestDB implements EnactRequestInterface{

    private int reqID;
    public enactChangeSupervisor(int reqID){
        this.reqID = reqID;
        initializeFiles();
        updateDB(null);
    }

    @Override
    public void updateDB() {

    }

    @Override
    public void enactRequest(int choice){
        switch(choice){
            // Approve
            case 1:
                new ChangeProjectSupervisor(choice);
                reqDB.findInstance(reqID).setRequestStatus(RequestStatus.APPROVED);
                break;

            // Reject
            case 0:
                reqDB.findInstance(reqID).setRequestStatus(RequestStatus.REJECTED);
                break;
                
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    
}
