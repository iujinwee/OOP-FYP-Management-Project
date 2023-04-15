package Boundaries.Request;

import Entity.RequestClass.RequestType;

public interface UpdateRequestDBInterface {
    /**
	 * Abstract method used to update Request Database.
	 * @param type Type of request
	 */
    abstract void updateDB(RequestType type);
}
