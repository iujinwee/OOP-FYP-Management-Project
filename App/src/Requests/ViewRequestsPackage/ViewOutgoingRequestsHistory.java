package Requests.ViewRequestsPackage;

import Requests.Request;
import Users.UserDetails.User;

public class ViewOutgoingRequestsHistory extends ViewRequestsHistory{
    
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

			if(req.getFromUser() == null){
				break;
			}

            if(req.getfromUserID().compareTo(user.getUserID())==0){
                count += viewRequest(req);
            }            
		}
    }
}
