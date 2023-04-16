package Boundaries.Request;

import Entity.RequestClass.Request;

public interface CreateRequestInterface {
    /**
	 * Abstract method used to create new request.
     * @return Request
	 */
    abstract public Request createRequest();
}
