package Controller.Request.ViewRequestController;

import Boundaries.Database.LoadFilesInterface;
import Boundaries.Request.ViewRequestInterface;
import Boundaries.Request.ViewRequestListInterface;
import Entity.DatabaseClass.RequestDB;
import Entity.RequestClass.Request;
import Entity.UserClass.UserDetails.User;

public abstract class ViewRequestController implements LoadFilesInterface, ViewRequestListInterface, ViewRequestInterface{
    public int count;
    public RequestDB reqDB;

    public ViewRequestController(User user){
        loadFiles();
        header();
        body(user);
        footer();
    }
	
    @Override
    public void loadFiles() {
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
		System.out.printf("> [%d] %s REQUEST - Project %d\n", req.getRequestID(), req.getRequestType().toString(), req.getProjectID());
		System.out.printf("       STATUS: %s\n", req.getRequestStatus().toString());
		System.out.printf("       From: %s | To: %s\n", req.getFromUser().getName(), req.getToUser().getName());
		if(req.getNewSupervisor()!=null){
			System.out.printf("       New Supervisor Name: %s\n", req.getNewSupervisor());	
		}
		
		if(req.getNewTitle()!=null){
			System.out.printf("       New Title: %s\n", req.getToUser().getUserID());	
		}
		return 1;
	}
}
