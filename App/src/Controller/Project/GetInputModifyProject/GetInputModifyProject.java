package Controller.Project.GetInputModifyProject;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.Interfaces.ExceptionHandlerInterface;
import Boundaries.Menu.Interfaces.GetInputInterface;
import Controller.Project.ModifyProject.ModifyProject;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class GetInputModifyProject extends ModifyProject implements GetInputInterface, ExceptionHandlerInterface {

    public handleInvalidInput handler = new handleInvalidInput(3);
    public Scanner sc = new Scanner(System.in);

    /** 
     * Get Input Modify Project Constructor.
     */
    public GetInputModifyProject(){
        super();
    }
    
	@Override
	public void handleException() {
        while(handler.checkAttempts()){
            try{
                getInput();
                break;
                
            }catch(InvalidInputException e){
                handler.handleInvalidInputException(e);
            }catch(InputMismatchException e){
                handler.handleInputMismatchException(e);
                sc.nextLine();
            }
        }
        
	}
}
