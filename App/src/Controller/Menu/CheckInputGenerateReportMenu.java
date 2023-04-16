package Controller.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.Interfaces.ExceptionHandlerInterface;
import Boundaries.Menu.Interfaces.GetInputInterface;
import Boundaries.Menu.Interfaces.ViewUserMenuInterface;
import Controller.Project.LoadProjectDB;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class CheckInputGenerateReportMenu extends LoadProjectDB implements ViewUserMenuInterface, ExceptionHandlerInterface, GetInputInterface {

    private handleInvalidInput handler = new handleInvalidInput(3);
	public Scanner sc = new Scanner(System.in);

    /** 
     * Check Input Generate Report Menu Constructor.
     */
    public CheckInputGenerateReportMenu() {
        super();
    }

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
