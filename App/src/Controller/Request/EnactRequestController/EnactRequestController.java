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

    public EnactRequestController(int reqID){
        loadFiles();
        this.request = reqDB.findInstance(reqID);
        updateDB();
        exportDB();
    }

    @Override
    public void loadFiles() {
        super.loadFiles();
        System.out.println("Initializing ProjectDB...");
        projDB = new ProjectDB();
        System.out.println("ProjectDB Initialized.");
    }

    @Override
    public void updateDB() {

        System.out.printf("\n> Choose to accept/ reject [Request #%s]\n", request.getRequestID());
        System.out.println("[1] Approve");
        System.out.println("[0] Reject");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        handleInvalidInput handler = new handleInvalidInput(sc, 3);
        
        while(handler.checkAttempts()){
            try{
                enactRequest(choice);
                break;
            }catch(InvalidInputException e){
                handler.handleInvalidInputException(e);

            }catch(InputMismatchException e){
                handler.handleInputMismatchException(e);
            }
        }
        
        sc.close();
    }

    @Override
    public void enactRequest(int choice) throws InvalidInputException{
        switch(choice){
            // Approve
            case 1:
                approve();
                request.setRequestStatus(RequestStatus.APPROVED);
                System.out.printf("Request #%d has been approved.", request.getRequestID());
                break;

            // Reject
            case 0:
                reject();
                request.setRequestStatus(RequestStatus.REJECTED);
                System.out.printf("Request #%d has been rejected.", request.getRequestID());
                break;
                
            default:
                throw new InvalidInputException();
        }
    }
}
