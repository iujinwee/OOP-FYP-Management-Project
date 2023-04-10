package Requests;

import java.util.ArrayList;

import Users.UserDetails.User;
import Users.UserDetails.UserType;
import Projects.ProjectDB;
import Database.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;




// ## MANAGING REQUEST
// USER SELECT OPTION (USER CLASS)

// DISPLAY LIST OF REQ (USER CLASS ACCESS REQUESTDB = TAKES IN USER ID = DISPLAY ACCORDINGLY)
// - req 1
// - req 2 

// ASK FOR INPUT (USER CLASS)
// Select 1 
// switch statement
// Request current_req = new ChangeTitle(); (Request contains content required)


// ASK FOR INPUT CHOICE TO MANAGE REQUEST (USER CLASS)

// MANAGE CURRENT REQUEST (REQUEST )
// current_req.enactRequest(db, requestStatus)

// enactRequest(db, requestStatus){
// 	switch(requestStatus){
// 		case approve: 

// 		case reject: 
// 	}
// }



// ## CREATING REQUEST 
// SEND REQUEST (USER CLASS = ACCESS REQUESTDB = CREATE NEW REQUEST CLASS)

// reqDB.createRequest(RequestType)

// switch (requestType) {
// 	case CHANGETITLE:
// 		// Get input
// 		Request newRequest = new ChangeTitle()
// 		break;

// 	default:
// 		break;
// }

// ReqDB.add(newRequest)
// Update excel


// VIEW USER (User Type)


public class RequestDB extends Database{

	private static ArrayList<Object> requestList;
	Scanner sc = new Scanner(System.in);


	public RequestDB(){
		loadDB();
		throw new UnsupportedOperationException();
	}
	public void createRequest(RequestType type) {
		switch (type) {
			case CHANGETITLE:
				System.out.println("Insert new title: ");
				String newTitle = sc.nextLine();
				requestList.add(new ChangeTitle(requestList.size(), newTitle));
				exportDB();
				break;
			case CHANGESUPERVISOR:
				System.out.println("Insert project ID: ");
				int projectID = sc.nextInt();
				System.out.println("Insert new supervisor ID: ");
				int newSupervisorID = sc.nextInt();
				requestList.add(new ChangeSupervisor(requestList.size(), newSupervisorID, projectID));
				exportDB();
				break;
			case REGISTERPROJECT:
				System.out.println("Insert project ID: ");
				projectID = sc.nextInt();
				requestList.add(new RegisterProject(requestList.size(), projectID));
				exportDB();
				break;
			case DEREGISTERPROJECT:
				System.out.println("Insert project ID: ");
				projectID = sc.nextInt();
				requestList.add(new DeregisterProject(requestList.size(), projectID));
				exportDB();
				break;
		}

		// Add new Request
		// Update Excel
		throw new UnsupportedOperationException();

	}

	public void manageRequest() {
		
		throw new UnsupportedOperationException();
	}

	public void viewRequest(User user) {
		switch(user.getUserType()){
			case STUDENT:
				for(Object request : requestList){
					Request req = (Request) request;
					if(req.getFromUser().equals(user)){
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
				for(Object request : requestList){
					Request req = (Request) request;
					if(req.getFromUser().equals(user)){
						System.out.println(req.toString());
					}
				}
				break;
				
			case FYP_COORDINATOR:
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

	public void loadDB(){
		requestList = FileHandler.readExcelFile("Requests.xlsx", new Request());
		throw new UnsupportedOperationException();
	}

	public void exportDB(){
		FileHandler.writeExcelFile("Requests.xlsx", requestList);
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

	public void viewAllRequests(String userID){
		// Filter result based on userType
	}

}