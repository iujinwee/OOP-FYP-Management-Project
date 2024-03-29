package Boundaries.Request.Classes;

import Entity.RequestClass.Request;
import Entity.UserClass.UserDetails.User;

public class ViewOutgoingRequestsHistory extends ViewRequestDB{
    
    /** 
     * View Outgoing Requests History Constructor.
     * @param user User Object
     */
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
