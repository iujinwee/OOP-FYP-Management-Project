package Users.UserDetails;
import Exceptions.InvalidInputException;

public interface UserInterface {

	public void startProgram();
	
	public void viewUserMenu();
	public void getInput() throws InvalidInputException;
}