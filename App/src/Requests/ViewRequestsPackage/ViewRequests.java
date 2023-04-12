package Requests.ViewRequestsPackage;

import Database.RequestDB;
import Requests.Request;

public abstract class ViewRequests implements RequestInterface, ViewRequestInterface{
    public int count;
    public RequestDB reqDB;

    @Override
    public void initializeFiles() {
        System.out.println("\nInitializing RequestDB...");
        reqDB = new RequestDB();
        System.out.println("RequestDB Initialized.\n");
    }

    @Override
    public void footer() {
        if(count == 0){
			System.out.println("=======     NO REQUESTS FOUND!     =======");
		}else{
			System.out.println("\n=========   END OF REQUEST LIST  ===========\n");
		}
    }

    @Override
    public int viewRequest(Request req){
		System.out.printf("> %s | Request #%d - %s\n", req.getRequestStatus(), req.getRequestID(), req.getRequestType().toString());
		System.out.printf("  Project Title: %s\n", req.getProjectID());
		System.out.printf("  From: %s | To: %s\n", req.getFromUser().getName(), req.getToUser().getName());
		if(req.getNewSupervisor()!=null){
			System.out.printf("  New Supervisor Name: %s\n", req.getNewSupervisor());	
		}
		
		if(req.getNewTitle()!=null){
			System.out.printf("  New Title: %s\n", req.getToUser().getUserID());	
		}
		return 1;
	}
}
