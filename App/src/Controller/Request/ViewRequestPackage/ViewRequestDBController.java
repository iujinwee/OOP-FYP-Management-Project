package Controller.Request.ViewRequestPackage;

import java.util.ArrayList;

import Boundaries.Menu.FooterInterface;
import Boundaries.Menu.HeaderInterface;
import Boundaries.Menu.UserBodyInterface;
import Boundaries.Request.ViewRequestInterface;
import Controller.Request.LoadRequestDBController;
import Entity.DatabaseClass.SupervisorDB;
import Entity.RequestClass.Request;
import Entity.UserClass.UserDetails.User;

public abstract class ViewRequestDBController extends LoadRequestDBController implements ViewRequestInterface, HeaderInterface, UserBodyInterface, FooterInterface{
    public ArrayList<Integer> requests = new ArrayList<>();

    public ViewRequestDBController(User user){
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
