package Entity.DatabaseClass;

import Entity.RequestClass.Request;

public class RequestDB extends Database{

	
	public RequestDB(){
		super("request_list.xlsx", new Request());
	}
	
	
	/** 
	 * Method to find instance of Request object in RequestDB, matched by the Request ID, not case sensitive.
	 * @param id Input Request ID to be found
	 * @return Request
	 */
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