package Requests;

import Users.UserDetails.User;
import Users.UserDetails.UserType;
import Projects.ProjectDB;
import Database.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RequestDB extends Database{

	private static ArrayList<Object> requestList;
	Scanner sc = new Scanner(System.in);


	public RequestDB(){
		super("Requests.xlsx", new Request());
		throw new UnsupportedOperationException();
	}
	public void createRequest(RequestType type, User fromUser, User toUser) {
		switch (type) {
			case CHANGETITLE:
				System.out.println("Insert new title: ");
				String newTitle = sc.nextLine();
				requestList.add(new ChangeTitle(super.size(), newTitle, fromUser, toUser));
				exportDB();
				break;
			case CHANGESUPERVISOR:
				System.out.println("Insert project ID: ");
				int projectID = sc.nextInt();
				System.out.println("Insert new supervisor ID: ");
				int newSupervisorID = sc.nextInt();
				requestList.add(new ChangeSupervisor(requestList.size(), newSupervisorID, projectID, fromUser, toUser));
				exportDB();
				break;
			case REGISTERPROJECT:
				System.out.println("Insert project ID: ");
				projectID = sc.nextInt();
				requestList.add(new RegisterProject(requestList.size(), projectID, fromUser, toUser));
				exportDB();
				break;
			case DEREGISTERPROJECT:
				System.out.println("Insert project ID: ");
				projectID = sc.nextInt();
				requestList.add(new DeregisterProject(requestList.size(), projectID, fromUser, toUser));
				exportDB();
				break;
		}
		throw new UnsupportedOperationException();

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