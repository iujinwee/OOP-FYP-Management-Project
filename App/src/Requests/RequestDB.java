package Requests;

import java.util.ArrayList;

import FileManager.FileReader;
import Requests.RequestDetails.Request;
import Requests.RequestDetails.RequestStatus;
import Requests.RequestDetails.RequestType;
import Users.UserDetails.User;

public class RequestDB {

	private ArrayList <Object> requestDB;

	

	public RequestDB(){
		// Load the Excel File  
		requestDB = FileReader.readExcelFile("request_list.xlsx", new Request());
	}
	
	
	public void createRequest(RequestType type) {
		// Switch case
	}

	public void updateRequest(int requestID, RequestStatus updatedStatus) {
		// TODO - implement RequestDB.updateRequest
		throw new UnsupportedOperationException();
	}

	public void viewRequest(int requestID) {
		// TODO - implement RequestDB.viewRequest
		throw new UnsupportedOperationException();
	}

	public void viewAllRequests(User user){
		// Filter result based on userType
	}

}