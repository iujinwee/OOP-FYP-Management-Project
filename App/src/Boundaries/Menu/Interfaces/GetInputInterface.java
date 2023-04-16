package Boundaries.Menu.Interfaces;

import Exceptions.InvalidInputException;

public interface GetInputInterface {
    /**
	 * Abstract method to get user input. Throws InvalidInputException when invalid inputs received.
	 * @throws InvalidInputException 
	 * @Invalid Beyond the Option Selection given or Non-numerical input 
	 */
	abstract public void getInput() throws InvalidInputException;
}
