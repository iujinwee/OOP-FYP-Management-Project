package Controller.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.Interfaces.ExceptionHandlerInterface;
import Boundaries.Menu.Interfaces.GetInputInterface;
import Boundaries.Menu.Interfaces.ViewUserMenuInterface;
import Controller.Project.LoadProjectDB;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class CheckInputFilteredReportMenu extends LoadProjectDB implements ViewUserMenuInterface, ExceptionHandlerInterface, GetInputInterface {

    public handleInvalidInput handler = new handleInvalidInput(3);
	public Scanner sc = new Scanner(System.in);

    public CheckInputFilteredReportMenu() {
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
