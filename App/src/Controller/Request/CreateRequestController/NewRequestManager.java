package Controller.Request.CreateRequestController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.BodyInterface;
import Boundaries.Menu.FooterInterface;
import Boundaries.Menu.GetInputInterface;
import Boundaries.Menu.HeaderInterface;
import Controller.Request.RequestDBManager;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class NewRequestManager extends RequestDBManager implements GetInputInterface, HeaderInterface, BodyInterface, FooterInterface {

    public RequestType type;
    public boolean created;
    public User fromUser;
    public User toUser;
    public int projID;
    handleInvalidInput handler = new handleInvalidInput();
    public Scanner sc = new Scanner(System.in);

    public NewRequestManager(User user){
        super();
        this.fromUser = user;
    }

    @Override
    public void header() {
        System.out.printf("\nCreating %s Request\n", type.toString());
        System.out.println("==================================");
    }
    

    
    public void body() {
        try {
            getInput();
        } catch (InvalidInputException e) {
            handler.handleInvalidInputException(e);
        } catch(InputMismatchException e) {
            handler.handleInputMismatchException(e);
        }
    }
    
    
    @Override
    public void footer() {
        System.out.println("\n==========      Request has been created!     ===========\n");

    }

    @Override
    public void exportDB() {
        super.exportDB();
    }
}
