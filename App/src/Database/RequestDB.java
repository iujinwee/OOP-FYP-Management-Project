package Database;

import Users.UserDetails.*;
import Requests.*;
import Requests.RequestType;

import java.util.Scanner;

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

                newReq = new ChangeTitle(super.size+1, newTitle, fromUser, toUser, projID);
				super.objectDB.add(newReq);
				super.exportDB();
				break;

			case CHANGESUPERVISOR:
				System.out.println("Insert new supervisor ID: ");
				String newSupervisorID = sc.next(); // TO CHECK IF VALID SUPERVISOR

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
		System.out.printf("  Project Title: %s\n", (projDB.findInstance(req.getProjectID())).getProjectTitle());
		System.out.printf("  From: %s | To: %s\n", req.getFromUser().getName(), req.getToUser().getName());
		System.out.printf("  Type: %s | Status: %s\n", req.getRequestType(), req.getRequestStatus());
		if(req.getNewSupervisor()!=null){
			System.out.printf("  New Supervisor Name: %s\n", req.getNewSupervisor());	
		}
		
		if(req.getNewTitle()!=null){
			System.out.printf("  New Title: %s\n", req.getToUser().getUserID());	
		}
	}

	public void viewPendingRequests(User user){
		System.out.println("\n==========================================");
		System.out.println("========     Pending Requests     ========");
		System.out.println("==========================================\n");

		int count = 0;

		for(Object request : objectDB){
			Request req = (Request) request;
			if(req.getToUser() == null){
				break;
			}
			if((req.getToUser().getUserID().compareTo(user.getUserID())==0) && (req.getRequestStatus().compareTo(RequestStatus.PENDING)==0)){
				viewRequest(req);
				count++;
			}
		}

		if(count==0){
			System.out.println("=======     No Pending Requests     =======");
		}else{
			System.out.println("\n=========   END OF REQUEST LIST  ===========\n");
		}
	}

	public void viewAllRequests(User user) {
		int count = 0; 

		switch(user.getUserType()){
			case STUDENT:
				System.out.println("\n=========================================");
				System.out.println("=========     Requests Sent     =========");
				System.out.println("=========================================\n");
				// System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
				for(Object request : objectDB){
					Request req = (Request) request;
					if(req.getFromUser().equals(user)){
						viewRequest(req);
					}
				}
				break;

			case SUPERVISOR:
				System.out.println("\n=========================================");
				System.out.println("========    Outgoing Requests     =======");
				System.out.println("=========================================\n");
				// System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
				for(Object request : objectDB){
					Request req = (Request) request;
					if(req.getFromUser().equals(user)){
						viewRequest(req);
					}
				}
				System.out.println("\n===========================================");
				System.out.println("========     Incoming Requests     ========");
				System.out.println("===========================================\n");
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