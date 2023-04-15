package Controller.Project.ModifyProjectController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.ExceptionHandlerInterface;
import Boundaries.Menu.GetInputInterface;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class GetInputModifyProjectController extends ModifyProjectController implements GetInputInterface, ExceptionHandlerInterface {

    public handleInvalidInput handler = new handleInvalidInput(3);
    public Scanner sc = new Scanner(System.in);

    public GetInputModifyProjectController(){
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
