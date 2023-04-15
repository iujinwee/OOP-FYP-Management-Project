package Boundaries.Request;

import Exceptions.InvalidInputException;

public interface EnactRequestInterface {
    /**
	 * Abstract method used to enact request. Throws InvalidInputException when invalid inputs received.
     * @param choice Approve or Reject request
     * @throws InvalidInputException
     * @Invalid Beyond the Option Selection given or Non-numerical input 
	 */
    abstract void enactRequest(int choice) throws InvalidInputException;
}
