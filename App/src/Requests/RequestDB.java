package Requests;

import Requests.Request.ChangeSupervisor;
import Requests.Request.ChangeTitle;
import Requests.Request.DeregisterProject;
import Requests.Request.RegisterProject;
import Requests.Request.Request;
import Requests.Request.RequestType;

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

	private Request[] requestDB;
	private static ArrayList<Request> requestList;
	Scanner sc = new Scanner(System.in);


	public RequestDB() {
		requestDB = FileReader.readExcelFile("Requests.xlsx");
		throw new UnsupportedOperationException();
	}
	public void createRequest(RequestType type) {
		switch (type) {
			case CHANGETITLE:
				System.out.println("Insert new title: ");
				String newTitle = sc.nextLine();
				requestDB.add(new ChangeTitle((requestDB.size() + 1), newTitle));
				break;
			case CHANGESUPERVISOR:
				System.out.println("Insert project ID: ");
				int projectID = sc.nextInt();
				System.out.println("Insert new supervisor ID: ");
				int newSupervisorID = sc.nextInt();
				requestDB.add(new ChangeSupervisor((requestDB.size() + 1), newSupervisorID, projectID));
				break;
			case REGISTERPROJECT:
				System.out.println("Insert project ID: ");
				projectID = sc.nextInt();
				requestDB.add(new RegisterProject((requestDB.size() + 1), projectID));
				break;
			case DEREGISTERPROJECT:
				requestDB.add(new DeregisterProject(requestDB.size() + 1));
				break;
		}
		throw new UnsupportedOperationException();

	}

	public void updateRequest(String filename) throws IOException {
		List alw = new ArrayList();

		for (int i = 0; i < requestDB.size(); i++) {
			Request req = (Request) requestDB.get(i);
			StringBuilder st = new StringBuilder();
			st.append(req.getRequestType());
			st.append('|');
			st.append(req.getFromUser());
			st.append('|');
			st.append(req.getToUser());
			st.append('|');
			st.append(req.getRequestStatus());
			alw.add(st.toString());
		}
		write(filename, alw);
		throw new UnsupportedOperationException();
	}

	public void viewRequest() {
		for (Request request : requestDB) {
			System.out.println(request);
		}
		throw new UnsupportedOperationException();
	}

	public Request getRequest(int requestID) {
		for (Request request : requestDB) {
			if (request.getRequestID() == requestID) {
				return request;
			}
		}
		throw new UnsupportedOperationException();
	}

	public static void write(String fileName, List data) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(fileName));

		try {
			for (int i = 0; i < data.size(); i++) {
				out.println((String) data.get(i));
			}
		} finally {
			out.close();
		}
	}

}