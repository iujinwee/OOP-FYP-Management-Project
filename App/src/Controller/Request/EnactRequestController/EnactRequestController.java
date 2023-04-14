package Controller.Request.EnactRequestController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Request.EnactRequestInterface;
import Boundaries.Request.ManageRequestInterface;
import Controller.Request.AccessRequestDBController;
import Entity.DatabaseClass.ProjectDB;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public abstract class EnactRequestController extends AccessRequestDBController implements EnactRequestInterface, ManageRequestInterface{
    
    public ProjectDB projDB;
    public Request request;
    private handleInvalidInput selectionHandler = new handleInvalidInput();
    private boolean enacted = false;

    public EnactRequestController(int reqID){
        loadFiles();
        this.request = reqDB.findInstance(reqID);

        updateDB();
        
        if(enacted){
            exportDB();
        }
    }

    @Override
    public void loadFiles() {
        super.loadFiles();
    }

    @Override
    public void updateDB() {

        System.out.printf("\n> Choose to accept/ reject [Request #%s]\n", request.getRequestID());
        System.out.println("[1] Approve");
        System.out.println("[0] Reject");
        
        Scanner sc = new Scanner(System.in);
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

    @Override
    public void enactRequest(int choice) throws InvalidInputException{
        switch(choice){
            // Approve
            case 1:
                approve();
                request.setRequestStatus(RequestStatus.APPROVED);
                System.out.println("\n==============================");
                System.out.printf("Request #%d has been approved.\n", request.getRequestID());
                System.out.println("==============================\n");

                break;

            // Reject
            case 0:
                reject();
                request.setRequestStatus(RequestStatus.REJECTED);
                System.out.println("\n==============================");
                System.out.printf("Request #%d has been rejected.", request.getRequestID());
                System.out.println("==============================\n");

                break;
                
            default:
                throw new InvalidInputException(choice);
        }
    }
}
