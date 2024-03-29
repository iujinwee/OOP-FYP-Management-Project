package Boundaries.Request.Classes;

import java.util.ArrayList;

import Boundaries.Menu.Interfaces.FooterInterface;
import Boundaries.Menu.Interfaces.HeaderInterface;
import Boundaries.Menu.Interfaces.UserBodyInterface;
import Boundaries.Request.Interfaces.ViewRequestInterface;
import Controller.Request.LoadRequestDB;
import Entity.DatabaseClass.SupervisorDB;
import Entity.RequestClass.Request;
import Entity.UserClass.UserDetails.User;

public abstract class ViewRequestDB extends LoadRequestDB implements ViewRequestInterface, HeaderInterface, UserBodyInterface, FooterInterface{
    public ArrayList<Integer> requests = new ArrayList<>();

    /** 
     * View Request Database Constructor.
     * @param user User Object
     */
    public ViewRequestDB(User user){
        super();
        header();
        body(user);
        footer();
    }

    @Override
    public void footer() {
        if(requests.size() == 0){
			System.out.println("=======     NO REQUESTS FOUND!     =======\n");
		}else{
			System.out.println("=========   END OF REQUEST LIST  ===========\n");
		}
    }


    @Override
    public int viewRequest(Request req){
		System.out.printf("> [%d] %s REQUEST - Project %d\n", req.getRequestID(), req.getRequestType().toString(), req.getProjectID());
		System.out.printf("      STATUS: %s\n", req.getRequestStatus().toString());
		System.out.printf("      From: %s | To: %s\n", req.getFromUser().getName(), req.getToUser().getName());
		
        if(req.getNewSupervisor()!=null){
            SupervisorDB supDB = new SupervisorDB();
			System.out.printf("      New Supervisor Name: %s\n", (supDB.findInstance(req.getNewSupervisor())).getName());	
		}
		
		if(req.getNewTitle()!=null){
			System.out.printf("      New Title: %s\n", req.getNewTitle());	
		}
        System.out.println("\n");
		return req.getRequestID();
	}
    
}
