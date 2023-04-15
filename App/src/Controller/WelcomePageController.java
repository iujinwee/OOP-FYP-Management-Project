package Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.*;
import Exceptions.handleInvalidInput;
import Exceptions.InvalidInputException;

public abstract class WelcomePageController implements HeaderInterface, ViewUserMenuInterface, GetInputInterface, ExceptionHandlerInterface {

    private handleInvalidInput handler = new handleInvalidInput(3);
    public Scanner sc = new Scanner(System.in);

    public WelcomePageController() {}

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
