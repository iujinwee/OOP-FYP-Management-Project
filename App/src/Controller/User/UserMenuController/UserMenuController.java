package Controller.User.UserMenuController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.ExceptionHandlerInterface;
import Boundaries.Menu.GetInputInterface;
import Boundaries.Menu.ViewUserMenuInterface;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class UserMenuController implements ViewUserMenuInterface, GetInputInterface, ExceptionHandlerInterface {

    private handleInvalidInput handler = new handleInvalidInput(3);
	public Scanner sc = new Scanner(System.in);

    @Override
    public void handleException() {
        while(handler.checkAttempts()) {
            try {    
                getInput();
                break;
    
            }catch(InputMismatchException e){
                handler.handleInputMismatchException(e);
                sc.nextLine();
                
            }catch(InvalidInputException e){
                handler.handleInvalidInputException(e);
            }
        } 
    }
}
