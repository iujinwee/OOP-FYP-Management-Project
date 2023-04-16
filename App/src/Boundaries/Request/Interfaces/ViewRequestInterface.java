package Boundaries.Request.Interfaces;

import Entity.RequestClass.Request;

public interface ViewRequestInterface {
    /**
	 * Abstract method used to view details of request.
	 * @param req Request Object
     * @return int
	 */
    abstract public int viewRequest(Request req);
}
