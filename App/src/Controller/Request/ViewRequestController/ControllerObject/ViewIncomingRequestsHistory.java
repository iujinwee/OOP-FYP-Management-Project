package Controller.Request.ViewRequestController.ControllerObject;

import Controller.Request.ViewRequestController.ViewRequestController;
import Entity.RequestClass.Request;
import Entity.UserClass.UserDetails.User;

public class ViewIncomingRequestsHistory extends ViewRequestController{
    
    public ViewIncomingRequestsHistory(User user){
        super(user);
    }

    @Override
    public void header() {
		System.out.println("\n=============================================");
		System.out.println("=====     Incoming Requests History     =====");
		System.out.println("=============================================\n");
    }

    @Override
    public void body(User user) {
        for(Object obj : reqDB.objectDB){
			Request req = (Request) obj;

			if(req.gettoUserID() == null){
				break;
			}

            if(req.gettoUserID().compareTo(user.getUserID())==0){
                requests.add(viewRequest(req));
            }            
		}
    }
}
