package Controller.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.Interfaces.ExceptionHandlerInterface;
import Boundaries.Menu.Interfaces.GetInputInterface;
import Boundaries.Menu.Interfaces.ViewUserMenuInterface;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class CheckInputUserMenuInput implements ViewUserMenuInterface, GetInputInterface, ExceptionHandlerInterface {

    private handleInvalidInput handler = new handleInvalidInput(3);
	public Scanner sc = new Scanner(System.in);

    /** 
     * Check Input User Menu Input Constructor.
     */
    public CheckInputUserMenuInput() {}

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
