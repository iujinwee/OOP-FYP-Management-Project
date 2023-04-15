package Controller.User.UserMenuController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.UserClass.Supervisor;
import Exceptions.handleInvalidInput;
import Exceptions.InvalidInputException;

public class SupervisorMenu extends UserMenuController {

    handleInvalidInput handler = new handleInvalidInput(3);
    
    public SupervisorMenu() {
        viewUserMenu();

        while(handler.checkAttempts()) {
            try {    
                getInput();
                break;
    
            }catch(InputMismatchException e){
                handler.handleInputMismatchException(e);
            }catch(InvalidInputException e){
                handler.handleInvalidInputException(e);
            }
        } 
    }

    @Override
    public void viewUserMenu() {
    
        
    }

    @Override
    public void getInput() throws InvalidInputException {
        
    }


