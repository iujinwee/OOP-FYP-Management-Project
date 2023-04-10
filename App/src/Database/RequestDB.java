package Database;

import Users.UserDetails.*;
import Requests.*;

import java.util.ArrayList;
import java.util.Scanner;

public class RequestDB extends Database{

	private static ArrayList<Object> requestList;
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
				// View Projects
				projDB.viewProjects(fromUser);

                System.out.println("Select Project to change supervisor:");
				int projectID = sc.nextInt();

				System.out.println("Insert new supervisor ID: ");
				String newSupervisorID = sc.next();

				newReq = new ChangeSupervisor(super.size+1, newSupervisorID, projectID, fromUser, toUser);
				super.objectDB.add(newReq);
				super.exportDB();
				break;

			case REGISTERPROJECT:
				// View Projects
				projDB.viewProjects(fromUser);

				System.out.println("Select Project to register:");
				projectID = sc.nextInt();

				newReq = new RegisterProject(super.size+1, projectID, fromUser, toUser);
				super.objectDB.add(newReq);
				super.exportDB();
				break;

			case DEREGISTERPROJECT:
				System.out.println("Select Project to deregister:");
				projectID = sc.nextInt();
				
				newReq = new DeregisterProject(super.size+1, projectID, fromUser, toUser);
				super.objectDB.add(newReq);
				super.exportDB();
				break;
		}
	}

	public void viewPendingRequests(User user){
		System.out.println("Pending requests");
		System.out.println("---------------------------------");
		System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
		switch(user.getUserType()){

			case STUDENT:
				for(Object request : requestList){
					Request req = (Request) request;
					if(req.getFromUser().equals(user) && req.getRequestStatus() == RequestStatus.PENDING){
						System.out.println(req.toString());
					}
				}
				break;
			case SUPERVISOR:
				for(Object request : requestList){
					Request req = (Request) request;
					if(req.getToUser().equals(user) && req.getRequestStatus() == RequestStatus.PENDING){
						System.out.println(req.toString());
					}
				}
				break;

			case FYPCOORDINATOR:
				for(Object request : requestList){
					Request req = (Request) request;
					if(req.getRequestStatus() == RequestStatus.PENDING){
						System.out.println(req.toString());
					}
				}
				break;
		}
		throw new UnsupportedOperationException();
	}

	public void viewAllRequests(User user) {
		switch(user.getUserType()){
			case STUDENT:
				System.out.println("Requests sent");
				System.out.println("---------------------------------");
				System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
				for(Object request : requestList){
					Request req = (Request) request;
					if(req.getFromUser().equals(user)){
						System.out.println(req.toString());
					}
				}
				break;

			case SUPERVISOR:
				System.out.println("Requests sent");
				System.out.println("---------------------------------");
				System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
				for(Object request : requestList){
					Request req = (Request) request;
					if(req.getFromUser().equals(user)){
						System.out.println(req.toString());
					}
				}
				System.out.println("---------------------------------");
				System.out.println("Requests received");
				System.out.println("---------------------------------");
				System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
				for(Object request : requestList){
					Request req = (Request) request;
					if(req.getToUser().equals(user)){
						System.out.println(req.toString());
					}
				}
				break;

			case FYPCOORDINATOR:
				System.out.println("Request ID\tFrom User\tTo User\tRequest Type\tRequest Status\tProject ID\tcontent");
				for(Object request : requestList){
					Request req = (Request) request;
					System.out.println(req.toString());
				}
				break;
		}
		throw new UnsupportedOperationException();
	}

	public Request getRequest(int requestID) {
		for (Object request : requestList) {
			Request req = (Request) request;
			if (req.getRequestID() == requestID) {
				return req;
			}
		}
		throw new UnsupportedOperationException();
	}


	public Request findInstance(int id){
		for (Object request : requestList) {
			Request req = (Request) request;
			if (req.getRequestID() == id) {
				return req;
			}
		}
		throw new UnsupportedOperationException();
	}


}