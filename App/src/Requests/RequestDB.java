package Requests;

public class RequestDB{

    private Request[] requestList;
    public RequestDB(){
        // initialize request database 
        
    }

    public void viewProjects{
        
    }

    public void createRequest(requestType){
        // add new request

        switch(requestType){
            case changetitle:
                Request newRequest = new Request(senderID, requestType);
        }
        updateDB(newRequest);
    }

    private boolean updateDB(Request newRequest){

        return true;
    }
}