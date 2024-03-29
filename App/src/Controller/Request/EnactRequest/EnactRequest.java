package Controller.Request.EnactRequest;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Request.EnactRequestInterface;
import Boundaries.Request.ManageRequestInterface;
import Controller.Request.ModifyRequestDB;
import Entity.DatabaseClass.ProjectDB;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class EnactRequest extends ModifyRequestDB implements EnactRequestInterface, ManageRequestInterface{
    
    public ProjectDB projDB = new ProjectDB();
    public Request request;
    private handleInvalidInput selectionHandler = new handleInvalidInput();
    private boolean enacted = false;
    Scanner sc = new Scanner(System.in);

    /** 
     * Enact Request Constructor.
     * @param reqID Unique ID of Request Object
     */
    public EnactRequest(int reqID){
        super();
        this.request = reqDB.findInstance(reqID);

        updateDB();
        
        if(enacted){
            exportDB();
        }
    }

    @Override
    public void updateDB() {

        System.out.printf("\n> Choose to accept/ reject [Request #%s]\n", request.getRequestID());
        System.out.println("[1] Approve");
        System.out.println("[0] Reject");
        System.out.printf("Enter Option: ");
        int choice = sc.nextInt();

        try{
            enactRequest(choice);
            enacted = true;

        }catch(InvalidInputException e){
            selectionHandler.handleInvalidInputException(e);

        }catch(InputMismatchException e){
            selectionHandler.handleInputMismatchException(e);
        }
    }

    
    /** 
     * @param choice
     * @throws InvalidInputException
     */
    @Override
    public void enactRequest(int choice) throws InvalidInputException{
        switch(choice){
            // Approve
            case 1:
                approve();
                request.setRequestStatus(RequestStatus.APPROVED);
                System.out.println("\n\n==============================");
                System.out.printf("Request #%d has been approved.\n", request.getRequestID());
                System.out.println("==============================\n");

                break;

            // Reject
            case 0:
                reject();
                request.setRequestStatus(RequestStatus.REJECTED);
                System.out.println("\n\n==============================");
                System.out.printf("Request #%d has been rejected.\n", request.getRequestID());
                System.out.println("==============================\n");

                break;
                
            default:
                throw new InvalidInputException(choice);
        }
    }
}
