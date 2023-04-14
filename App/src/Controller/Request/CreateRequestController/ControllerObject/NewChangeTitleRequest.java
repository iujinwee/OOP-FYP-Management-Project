package Controller.Request.CreateRequestController.ControllerObject;

import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Controller.Request.CreateRequestController.NewRequestController;
import Entity.DatabaseClass.FYPCoordinatorDB;
import Entity.RequestClass.RequestType;
import Entity.RequestClass.RequestSubClass.ChangeTitleRequest;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;

public class NewChangeTitleRequest extends NewRequestController{

    FYPCoordinatorDB FYPDB = new FYPCoordinatorDB();
    String newTitle;

    public NewChangeTitleRequest(User user){
        super(user);
        this.type = RequestType.CHANGETITLE;

        header();
        body();
        
        if(created){
            footer();
        }
    }

    @Override
    public void updateDB() {
        reqDB.objectDB.add((new ChangeTitleRequest(reqDB.size+1, projID, fromUser, toUser, newTitle)).createRequest());
    }

    @Override
    public void getInput() throws InvalidInputException {
        
        ViewPersonalProjects projs = new ViewPersonalProjects(fromUser);

        // View Projects
		if (projs.projects.size() != 0) {
            projID = projs.projects.get(0);
            toUser = projs.projDB.findInstance(projID).getSupervisor();

			System.out.printf("Enter New Title: ");
            newTitle = sc.next();
            
            System.out.printf("\nChange Title of Assigned Project to [%s]?\n", newTitle);
            System.out.println("[1] Yes");
            System.out.println("[0] No");
            System.out.printf("\nEnter Option: ");
            int choice = sc.nextInt();
            System.out.println("");
            
            if(choice == 1){
                updateDB();
                exportDB();
            }else if(choice == 0){
                System.out.println("\nChange Title Request was cancelled.\n");
            }else{
                throw new InvalidInputException(choice);
            }
		}
    }
}