package Controller.Request.CreateRequest;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.Interfaces.BodyInterface;
import Boundaries.Menu.Interfaces.FooterInterface;
import Boundaries.Menu.Interfaces.GetInputInterface;
import Boundaries.Menu.Interfaces.HeaderInterface;
import Controller.Request.ModifyRequestDB;
import Entity.RequestClass.RequestType;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class CreateRequest extends ModifyRequestDB implements GetInputInterface, HeaderInterface, BodyInterface, FooterInterface {

    public RequestType type;
    public boolean created;
    public User fromUser;
    public User toUser;
    public int projID;
    handleInvalidInput handler = new handleInvalidInput();
    public Scanner sc = new Scanner(System.in);

    /** 
     * Create Request Constructor.
     * @param user User Object
     */
    public CreateRequest(User user){
        super();
        this.fromUser = user;
    }

    @Override
    public void header() {
        System.out.printf("\nCreating %s Request\n", type.toString());
        System.out.println("==================================");
    }
    
    @Override
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
