package Controller.Request.ViewRequestController.ControllerObject;

import Controller.Request.ViewRequestController.ViewRequestController;
import Entity.RequestClass.Request;
import Entity.UserClass.UserDetails.User;

public class ViewAllRequestsHistory extends ViewRequestController{
    
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
          requests.add(viewRequest(req));
        }
    }
}
