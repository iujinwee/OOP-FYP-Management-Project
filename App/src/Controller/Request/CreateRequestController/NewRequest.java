package Controller.Request.CreateRequestController;

import Boundaries.Request.ViewRequestListInterface;
import Controller.Request.AccessRequestDBController;
import Entity.RequestClass.RequestType;
import Entity.RequestClass.RequestSubClass.ChangeSupervisorRequest;
import Entity.RequestClass.RequestSubClass.ChangeTitleRequest;
import Entity.RequestClass.RequestSubClass.DeregisterProjectRequest;
import Entity.RequestClass.RequestSubClass.RegisterProjectRequest;
import Entity.UserClass.UserDetails.User;

public class NewRequest extends AccessRequestDBController implements ViewRequestListInterface {

    private RequestType type;
    private User fromUser;
    private User toUser;
    private int projID;

    public NewRequest(RequestType type, User fromUser, User toUser, int projID){
        this.type = type;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.projID = projID;

        loadFiles();
        header();
        body(fromUser);
        footer();
    }

    @Override
    public void header() {
        System.out.println("==================================================");
        System.out.printf("====     Creating %s Request     ====\n", type.toString());
        System.out.println("==================================================");
    }
    
    @Override
    public void body(User user) {
        updateDB();
        exportDB();
    }

    @Override
    public void footer() {
        System.out.println("==========      Request has been created!     ===========");

    }

    @Override
    public void updateDB() {

        switch(type){
            case CHANGESUPERVISOR:
                reqDB.objectDB.add((new ChangeSupervisorRequest(reqDB.size+1, projID, fromUser, toUser)).createRequest());
                break;

            case CHANGETITLE:
                reqDB.objectDB.add((new ChangeTitleRequest(reqDB.size+1, fromUser, toUser, projID)).createRequest());
                break;

            case REGISTERPROJECT:
                reqDB.objectDB.add((new RegisterProjectRequest(reqDB.size+1, projID, fromUser, toUser)).createRequest());
                break;

            case DEREGISTERPROJECT:
                reqDB.objectDB.add((new DeregisterProjectRequest(reqDB.size+1, projID, fromUser, toUser)).createRequest());
                break;

            default:
                break;
        }
    }

}
