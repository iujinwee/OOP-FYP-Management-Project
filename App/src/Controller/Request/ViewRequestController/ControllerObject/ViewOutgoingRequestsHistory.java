package Controller.Request.ViewRequestController.ControllerObject;

import Controller.Request.ViewRequestController.ViewRequestController;
import Entity.RequestClass.Request;
import Entity.UserClass.UserDetails.User;

public class ViewOutgoingRequestsHistory extends ViewRequestController{
    
    public ViewOutgoingRequestsHistory(User user){
        super(user);
    }

    @Override
    public void header() {
		System.out.println("\n=============================================");
		System.out.println("=====     Outgoing Requests History     =====");
		System.out.println("=============================================\n");
    }

    @Override
    public void body(User user) {
        for(Object obj : reqDB.objectDB){
			Request req = (Request) obj;

			if(req.getfromUserID() == null){
				break;
			}

            if(req.getfromUserID().compareTo(user.getUserID())==0){
                requests.add(viewRequest(req));
            }            
		}
    }
}
