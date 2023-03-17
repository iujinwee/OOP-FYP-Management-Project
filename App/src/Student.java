public class Student extends User{
    private String studentId;
    private RequestList requestDB;
    
    public Student(){
        this.studentId = super.getUserId();

        RequestDB requestDB = new RequestDB();
        
        
    }

    private createRequest(){
        requestDB.createRequest(requestType); // changetitle, registers, deregister
    }

    public viewProjects(){
        
    }
    public showMenu(){
        PRINT STATEMENTS
        // [1] create req

        // [2] show avail projects 
        // [3] show registered projects

        ASK FOR INPUT 

        switch(CHOICE)
            case 1:
                requestDB.viewProjects(userType)
            case 2:
                
    }
}


public class RequestDB{

    private Request[] requestList;
    public RequestDB(){
        // initialize request database 
        
    }

    public viewProjects{
        // for loop print
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