package Users.UserDetails;
import Exceptions.InvalidInputException;

public interface UserInterface {
	/**
	 * Function to start program and display User Menu
	 */
	abstract public void startProgram();
	/**
	 * Abstract Function to display User Menu
	 */
	abstract public void viewUserMenu();
	/**
	 * Abstract Function to get user input. Throws InvalidInputException when invalid inputs received.
	 * @throws InvalidInputException 
	 * @Invalid Beyond the Option Selection given or Non-numerical input 
	 */
	abstract public void getInput() throws InvalidInputException;

	/**
	 * Loads Project and RequestDB into User Program.
	 * @param reload represents a boolean to re-initialize the files.
	 */
	abstract public void loadFiles(boolean reload);
}