package Database;

import Users.UserDetails.*;
import Requests.*;
import Requests.RequestType;
import Requests.RequestClasses.ChangeSupervisorRequest;
import Requests.RequestClasses.ChangeTitleRequest;
import Requests.RequestClasses.DeregisterProjectRequest;
import Requests.RequestClasses.RegisterProjectRequest;
import Database.Interface.CreateRequestInterface;

public class RequestDB extends Database implements CreateRequestInterface{

	private ProjectDB projDB = new ProjectDB();
	
	public RequestDB(){
		super("request_list.xlsx", new Request());
	}
    
	public void createRequest(RequestType type, User fromUser, User toUser, int projID) {
		Request newReq;

		switch (type) {
			case CHANGETITLE:

				System.out.println("Insert new title: ");
				String newTitle = sc.next();

                newReq = new ChangeTitleRequest(super.size+1, newTitle, fromUser, toUser, projID);
				super.objectDB.add(newReq);
				super.exportDB();
				break;

			case CHANGESUPERVISOR:
				System.out.println("Insert new supervisor ID: ");
				String newSupervisorID = sc.next(); // TO CHECK IF VALID SUPERVISOR

				newReq = new ChangeSupervisorRequest(super.size+1, newSupervisorID, projID, fromUser, toUser);
				super.objectDB.add(newReq);
				super.exportDB();
				break;

			case REGISTERPROJECT:
				newReq = new RegisterProjectRequest(super.size+1, projID, fromUser, toUser);
				super.objectDB.add(newReq);
				super.exportDB();
				break;

			case DEREGISTERPROJECT:				
				newReq = new DeregisterProjectRequest(super.size+1, projID, fromUser, toUser);
				super.objectDB.add(newReq);
				super.exportDB();
				break;
		}
	}

	public Request findInstance(int id){
		for (Object request : super.objectDB) {
			Request req = (Request) request;
			if (req.getRequestID() == id) {
				return req;
			}
		}
		return new Request();
	}
}