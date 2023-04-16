package Boundaries.Request.Classes;

import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.UserClass.UserDetails.User;

public class ViewPendingRequests extends ViewRequestDB {

    public ViewPendingRequests(User user){
        super(user);
    }

    @Override
    public void header() {
		System.out.println("\n==========================================");
		System.out.println("========     Pending Requests     ========");
		System.out.println("==========================================\n");
    }

    @Override
    public void body(User user) {
        for(Object obj : reqDB.objectDB){
			Request req = (Request) obj;

			if(req.getToUser() == null){
				break;
			}

            // Filter only PENDING requests
            if(req.getRequestStatus().compareTo(RequestStatus.PENDING)==0){
                switch(user.getUserType()){

                    case STUDENT: 
                        if(req.getToUser().getUserID().compareTo(user.getUserID())==0){
                            requests.add(viewRequest(req));
                        }
                        break;

                    // View His/Her Pending
                    case SUPERVISOR:
                        if(req.getToUser().getUserID().compareTo(user.getUserID())==0){
                            requests.add(viewRequest(req));
                        }
                        break;

                    // View All Pending 
                    case FYPCOORDINATOR:
                        requests.add(viewRequest(req));
                        break;
    
                    default:
                        break;
                }
            }
		}
    }
}
