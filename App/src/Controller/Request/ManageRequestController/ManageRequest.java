package Controller.Request.ManageRequestController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.GetInputInterface;
import Boundaries.Request.ViewRequestListInterface;
import Controller.Project.ViewProjectController.ViewFullProjectInfo;
import Controller.Request.EnactRequestController.ControllerObject.*;
import Controller.Request.ViewRequestController.ControllerObject.ViewPendingRequests;
import Entity.DatabaseClass.ProjectDB;
import Entity.RequestClass.Request;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public class ManageRequest implements GetInputInterface, ViewRequestListInterface{
    Scanner sc = new Scanner(System.in);
    ViewPendingRequests pend;
    handleInvalidInput handler;

    public ManageRequest(User user, handleInvalidInput handler){
        this.handler = handler;
        header();
        body(user);
        footer();
    }

    @Override
    public void getInput() throws InvalidInputException {
        System.out.println("Enter Request ID to manage request:");
        int choice = sc.nextInt();
        if(pend.requests.contains(choice)){

            // Display Request
            Request selectedRequest = pend.reqDB.findInstance(choice);
            new ViewFullProjectInfo((new ProjectDB()).findInstance(choice));

            // Enact request based on Request Type
            switch(selectedRequest.getRequestType()){
                case CHANGESUPERVISOR: 
                    new EnactChangeSupervisor(choice);
                    break;

                case CHANGETITLE:
                    new EnactChangeTitle(choice);
                    break;

                case REGISTERPROJECT:
                    new EnactRegisterProject(choice);
                    break;

                case DEREGISTERPROJECT:
                    new EnactDeregisterProject(choice);
                    break;

                default:
                    throw new InvalidInputException();
            }
        }
    }

    @Override
    public void body(User user) {
        pend = new ViewPendingRequests(user);

        // Check if pending request
        if(pend.requests.size()!=0){
            try{
                getInput(); // Get selection of request

            }catch(InvalidInputException e){
                handler.handleInvalidInputException(e);
                
            }catch(InputMismatchException e){
                handler.handleInputMismatchException(e);
            }
        }
    }

    @Override
    public void header() {
        System.out.println("===========================================");
        System.out.println("=========     REQUEST MANAGER     =========");
        System.out.println("===========================================");
    }

    @Override
    public void footer() {
        if(pend.requests.size()==0){
            System.out.println("\n========    No Pending Requests.    ========");
        }else{
            System.out.println("\n=========    Request %d has been resolved.    =========");
        }
    }
}
