package Requests;

import java.util.ArrayList;

import FileManager.FileReader;
import Requests.RequestDetails.ChangeSupervisor;
import Requests.RequestDetails.DeregisterProject;
import Requests.RequestDetails.RegisterProject;
import Requests.RequestDetails.ChangeTitle;
import Requests.RequestDetails.Request;
import Requests.RequestDetails.RequestStatus;
import Requests.RequestDetails.RequestType;
import Users.UserDetails.User;
import Users.UserDetails.UserType;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;
import java.util.StringTokenizer;

import Projects.ProjectDB;

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


public class RequestDB {

	private static ArrayList<Object> requestList;
	Scanner sc = new Scanner(System.in);


	public RequestDB() {
		requestList = FileReader.readExcelFile("Requests.xlsx", new Request());
		throw new UnsupportedOperationException();
	}
	public void createRequest(RequestType type) {
		switch (type) {
			case CHANGETITLE:
				System.out.println("Insert new title: ");
				String newTitle = sc.nextLine();
				requestList.add(new ChangeTitle(requestList.size(), newTitle));
				FileManager.FileWriter.writeExcelFile("Requests.xlsx", requestList);
				break;
			case CHANGESUPERVISOR:
				System.out.println("Insert project ID: ");
				int projectID = sc.nextInt();
				System.out.println("Insert new supervisor ID: ");
				int newSupervisorID = sc.nextInt();
				requestList.add(new ChangeSupervisor(requestList.size(), newSupervisorID, projectID));
				FileManager.FileWriter.writeExcelFile("Requests.xlsx", requestList);
				break;
			case REGISTERPROJECT:
				System.out.println("Insert project ID: ");
				projectID = sc.nextInt();
				requestList.add(new RegisterProject(requestList.size(), projectID));
				FileManager.FileWriter.writeExcelFile("Requests.xlsx", requestList);
				break;
			case DEREGISTERPROJECT:
				System.out.println("Insert project ID: ");
				projectID = sc.nextInt();
				requestList.add(new DeregisterProject(requestList.size(), projectID));
				FileManager.FileWriter.writeExcelFile("Requests.xlsx", requestList);
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
		for(Object request : requestList){
			Request req = (Request) request;
			if(req.getFromUser().equals(user)){
				System.out.println(req.toString());
			}
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

}