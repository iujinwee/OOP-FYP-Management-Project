package Controller.Request.ManageRequestController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.FooterInterface;
import Boundaries.Menu.GetInputInterface;
import Boundaries.Menu.HeaderInterface;
import Boundaries.Menu.UserBodyInterface;
import Controller.Request.EnactRequestController.ControllerObject.*;
import Controller.Request.ViewRequestPackage.ControllerObject.ViewPendingRequests;
import Entity.DatabaseClass.ProjectDB;
import Entity.RequestClass.Request;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public class RequestManager implements GetInputInterface, HeaderInterface, UserBodyInterface, FooterInterface{
    private Scanner sc = new Scanner(System.in);
    private ViewPendingRequests pend;
    private handleInvalidInput handler = new handleInvalidInput();
    private Request selectedRequest;

    public RequestManager(User user){
        header();
        body(user);
        footer();
    }

    
    /** 
     * @param user
     */
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
                sc.nextLine();
                handler.handleInputMismatchException(e);
            }
        }
    }

    @Override
    public void getInput() throws InvalidInputException {
        System.out.printf("Enter Request ID to manage request: ");
        int choice = sc.nextInt();

        if(pend.requests.contains(choice)){

            // Display Request
            selectedRequest = pend.reqDB.findInstance(choice);
            (new ProjectDB()).findInstance(selectedRequest.getProjectID()).viewFullProjectInfo();

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
                    throw new InvalidInputException(choice);
            }
        }else{
            throw new InvalidInputException(choice);
        }
    }

    @Override
    public void header() {
        System.out.println("*******************************************");
        System.out.println("*********     REQUEST MANAGER     *********");
        System.out.println("*******************************************");
    }

    @Override
    public void footer() {
        if(pend.requests.size()==0){
            System.out.println("\n*********    No Pending Requests.    *********\n");
        }
    }
}
