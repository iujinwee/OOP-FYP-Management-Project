package Controller.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.Interfaces.ExceptionHandlerInterface;
import Boundaries.Menu.Interfaces.GetInputInterface;
import Boundaries.Menu.Interfaces.ViewUserMenuInterface;
import Exceptions.handleInvalidInput;
import Exceptions.InvalidInputException;

public abstract class CheckInputWelcomePage implements ViewUserMenuInterface, GetInputInterface, ExceptionHandlerInterface {

    private handleInvalidInput handler = new handleInvalidInput(3);
    public Scanner sc = new Scanner(System.in);

    /** 
     * Check Input Welcome Page Constructor.
     */
    public CheckInputWelcomePage() {}

    @Override
    public void handleException() {
        while(handler.checkAttempts()) {
            try {    
                getInput();
                break;
    
            }catch(InputMismatchException e){
                handler.handleInputMismatchException(e);
                sc.nextLine();
                continue;
                
            }catch(InvalidInputException e){
                handler.handleInvalidInputException(e);
            }
        } 
    }
}
