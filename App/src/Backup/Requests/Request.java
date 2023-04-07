package Backup.Requests;

public class Request {
    private int requestID, projectID;
    private RequestType requestType;
    private User fromUser, toUser;
    private RequestStatus requestStatus;

    public Request(RequestType requestType){
        this.requestStatus = RequestStatus.PENDING;
        switch(requestType){
            case CHANGETITLE:
                this.requestType = RequestType.CHANGETITLE;
                break;
            case CHANGESUPERVISOR:
                this.requestType = RequestType.CHANGESUPERVISOR;
                break;
            case REGISTERPROJECT:
                this.requestType = RequestType.REGISTERPROJECT;
                break;
            case DEREGISTERPROJECT:
                this.requestType = RequestType.DEREGISTERPROJECT;
                break;
        }
    }
    
}

enum RequestType{
    CHANGETITLE, CHANGESUPERVISOR, REGISTERPROJECT, DEREGISTERPROJECT
}

enum RequestStatus{
    PENDING, ACCEPTED, REJECTED
}
