package Requests.ViewRequestsPackage;

import Requests.Request;
import Requests.RequestStatus;
import Users.UserDetails.User;

public class ViewPendingRequests extends ViewRequests {

    public ViewPendingRequests(User user){
        initializeFiles();
        header();
        body(user);
        footer();
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
                    case SUPERVISOR:
                        if(req.getToUser().getUserID().compareTo(user.getUserID())==0){
                            count += viewRequest(req);
                        }
                        break;
    
                    case FYPCOORDINATOR:
                        count += viewRequest(req);
                        break;
    
                    default:
                        break;
                }
            }
		}
    }
}
