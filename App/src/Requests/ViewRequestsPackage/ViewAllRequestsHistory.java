package Requests.ViewRequestsPackage;

import Requests.Request;
import Users.UserDetails.User;

public class ViewAllRequestsHistory extends ViewRequestsHistory{
    
    public ViewAllRequestsHistory(User user){
        super(user);
    }

    @Override
    public void header() {
		System.out.println("\n=============================================");
		System.out.println("=======     Full Requests History     =======");
		System.out.println("=============================================\n");
    }

    @Override
    public void body(User user) {
        for(Object obj : reqDB.objectDB){
			Request req = (Request) obj;

			if(req.getToUser() == null){
				break;
			}
            count += viewRequest(req);
		}
    }
}
