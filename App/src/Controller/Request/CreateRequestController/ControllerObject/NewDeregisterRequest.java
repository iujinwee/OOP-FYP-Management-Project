package Controller.Request.CreateRequestController.ControllerObject;

import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Controller.Request.CreateRequestController.NewRequestManager;
import Entity.DatabaseClass.FYP_CoordinatorDB;
import Entity.RequestClass.RequestType;
import Entity.RequestClass.RequestSubClass.DeregisterProjectRequest;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;

public class NewDeregisterRequest extends NewRequestManager{

    FYP_CoordinatorDB FYPDB = new FYP_CoordinatorDB();

    public NewDeregisterRequest(User user){
        super(user);
        this.type = RequestType.DEREGISTERPROJECT;

        header();
        body();
        
        if(created){
            footer();
        }
    }

    @Override
    public void updateDB() {

        reqDB.objectDB.add((new DeregisterProjectRequest(reqDB.size+1, projID, fromUser, FYPDB.findInstance())).createRequest());
    }

    @Override
    public void getInput() throws InvalidInputException {
        
        ViewPersonalProjects projs = new ViewPersonalProjects(fromUser);

        // View Projects
		if (projs.projects.size() != 0) {
            projID = projs.projects.get(0);

			System.out.println("Deregister this assigned project?");
            System.out.println("[1] Yes");
            System.out.println("[0] No");
            System.out.printf("\nEnter Option: ");
            int choice = sc.nextInt();
            System.out.println("");
            
            if(choice == 1){
                updateDB();
                exportDB();
            }else if(choice == 0){
                System.out.println("\nDeregister Project Request was cancelled.\n");
            }else{
                throw new InvalidInputException(choice);
            }
		}
    }
}