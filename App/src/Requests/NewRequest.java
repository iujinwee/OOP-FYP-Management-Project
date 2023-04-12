package Requests;

import Requests.RequestClasses.ChangeSupervisorRequest;
import Requests.RequestClasses.ChangeTitleRequest;
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
                new ChangeSupervisorRequest(reqDB.size+1, projID, fromUser, toUser);
                break;

            case CHANGETITLE:
                new ChangeTitleRequest(reqDB.size+1, null, fromUser, toUser, projID);
                break;

            case REGISTERPROJECT:
                new RegisterProjectRequest(reqDB.size+1, projID, fromUser, toUser);
                break;

            case DEREGISTERPROJECT:

                break;

            default:
                break;
        }
    }


}
