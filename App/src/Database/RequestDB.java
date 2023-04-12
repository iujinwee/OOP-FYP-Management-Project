package Database;

import Requests.*;


public class RequestDB extends Database{

	
	public RequestDB(){
		super("request_list.xlsx", new Request());
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