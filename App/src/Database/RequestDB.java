package Database;

import Users.UserDetails.*;
import Requests.*;
import Requests.RequestType;

import java.util.Scanner;

public class RequestDB extends Database{

	private ProjectDB projDB = new ProjectDB();
	
	public RequestDB(){
		super("request_list.xlsx", new Request());
	}
    
	public void createRequest(RequestType type, User fromUser, User toUser, int projID) {
        Scanner sc = new Scanner(System.in);
		Request newReq;

		switch (type) {
			case CHANGETITLE:

				System.out.println("Insert new title: ");
				String newTitle = sc.next();

                newReq = new ChangeTitle(super.size+1, newTitle, fromUser, toUser, projID);
				super.objectDB.add(newReq);
				super.exportDB();
				break;

			case CHANGESUPERVISOR:
				System.out.println("Insert new supervisor ID: ");
				String newSupervisorID = sc.next();

				newReq = new ChangeSupervisor(super.size+1, newSupervisorID, projID, fromUser, toUser);
				super.objectDB.add(newReq);
				super.exportDB();
				break;

			case REGISTERPROJECT:
				newReq = new RegisterProject(super.size+1, projID, fromUser, toUser);
				super.objectDB.add(newReq);
				super.exportDB();
				break;

			case DEREGISTERPROJECT:				
				newReq = new DeregisterProject(super.size+1, projID, fromUser, toUser);
				super.objectDB.add(newReq);
				super.exportDB();
				break;
		}
	}

	public void viewRequest(Request req){
		System.out.printf("> Request #%d\n", req.getRequestID());
		System.out.printf("  From: %s -> To: %s\n", req.getFromUser().getName(), req.getToUser().getName());
		System.out.printf("\tType: %s | Status: %s\n", req.getRequestType(), req.getRequestStatus());
		System.out.printf("\tProject Title: %s\n", (projDB.findInstance(req.getProjectID())).getProjectTitle());
		if(req.getNewSupervisor()!=null){
			System.out.printf("\tNew Supervisor Name: %s\n", req.getNewSupervisor());	
		}
		
		if(req.getNewTitle()!=null){
			System.out.printf("\tNew Title: %s\n", req.getToUser().getUserID());	
		}
	}

	public void viewPendingRequests(User user){
		System.out.println("\nPending requests");
		System.out.println("---------------------------------");

		switch(user.getUserType()){

			case STUDENT:
			case SUPERVISOR:
				for(Object request : objectDB){
					Request req = (Request) request;
					if(req.getToUser().equals(user) && req.getRequestStatus() == RequestStatus.PENDING){
						viewRequest(req);
					}
				}
				break;

			case FYPCOORDINATOR:
				for(Object request : objectDB){
					Request req = (Request) request;
					if(req.getRequestStatus() == RequestStatus.PENDING){
						viewRequest(req);
					}
				}
				break;
		}
	}

	public void viewAllRequests(User user) {
		switch(user.getUserType()){
			case STUDENT:
				System.out.println("\nRequests sent");
				System.out.println("---------------------------------");
				// System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
				for(Object request : objectDB){
					Request req = (Request) request;
					if(req.getFromUser().equals(user)){
						viewRequest(req);
					}
				}
				break;

			case SUPERVISOR:
				System.out.println("\nRequests sent");
				System.out.println("---------------------------------");
				// System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
				for(Object request : objectDB){
					Request req = (Request) request;
					if(req.getFromUser().equals(user)){
						viewRequest(req);
					}
				}
				System.out.println("\n---------------------------------");
				System.out.println("Requests received");
				System.out.println("---------------------------------");
				// System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
				for(Object request : objectDB){
					Request req = (Request) request;
					if(req.getFromUser().equals(user)){
						viewRequest(req);
					}
				}
				break;

			case FYPCOORDINATOR:
				// System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
				for(Object request : objectDB){
					Request req = (Request) request;
					viewRequest(req);
				}
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