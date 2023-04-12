package Requests;

import Requests.RequestClasses.ChangeSupervisorRequest;
import Requests.RequestClasses.ChangeTitleRequest;
import Requests.RequestClasses.DeregisterProjectRequest;
import Requests.RequestClasses.RegisterProjectRequest;
import Users.UserDetails.User;

public class NewRequest extends ModifyRequestDB {

    private RequestType type;
    private User fromUser;
    private User toUser;
    private int projID;

    public NewRequest(RequestType type, User fromUser, User toUser, int projID){
        this.type = type;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.projID = projID;

        initializeFiles();
        updateDB(type);
        exportDB();
    }

    @Override
    public void updateDB(RequestType type) {
        System.out.printf("Creating %s Request\n", type.toString());

        switch(type){
            case CHANGESUPERVISOR:
                reqDB.objectDB.add((new ChangeSupervisorRequest(reqDB.size+1, projID, fromUser, toUser)).createRequest());
                break;

            case CHANGETITLE:
                reqDB.objectDB.add((new ChangeTitleRequest(reqDB.size+1, fromUser, toUser, projID)).createRequest());
                break;

            case REGISTERPROJECT:
                RegisterProjectRequest rp = new RegisterProjectRequest(reqDB.size+1, projID, fromUser, toUser);
                Request x = rp.createRequest();
                reqDB.objectDB.add(x);
                break;

            case DEREGISTERPROJECT:
                reqDB.objectDB.add((new DeregisterProjectRequest(reqDB.size+1, projID, fromUser, toUser)).createRequest());
                break;

            default:
                break;
        }
    }


}
