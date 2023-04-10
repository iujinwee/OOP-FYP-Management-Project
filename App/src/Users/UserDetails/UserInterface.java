package Users.UserDetails;
import Exceptions.InvalidInputException;

public interface UserInterface {

	abstract public void startProgram();
	
	abstract public void viewUserMenu();
	abstract public void getInput() throws InvalidInputException;
}