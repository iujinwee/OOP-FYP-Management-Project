package Requests.ViewRequestsPackage;

import Requests.Request;
import Users.UserDetails.User;

public class ViewIncomingRequestsHistory extends ViewRequestsHistory{
    
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

			if(req.getToUser() == null){
				break;
			}

            if(req.gettoUserID().compareTo(user.getUserID())==0){
                count += viewRequest(req);
            }            
		}
    }
}
