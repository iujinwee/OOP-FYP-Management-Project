package Controller.Request.CreateRequestController.ControllerObject;

import java.util.Scanner;

import Controller.Project.ViewProjectController.ControllerObject.ViewAvailableProjects;
import Controller.Request.CreateRequestController.NewRequestController;
import Entity.DatabaseClass.FYPCoordinatorDB;
import Entity.RequestClass.RequestType;
import Entity.RequestClass.RequestSubClass.RegisterProjectRequest;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public class NewRegisterRequest extends NewRequestController{

    handleInvalidInput handler = new handleInvalidInput();
    Scanner sc = new Scanner(System.in);

    public NewRegisterRequest(User user){
        super(user);
        this.type = RequestType.REGISTERPROJECT;

        header();
        body();
        
        if(created){
            footer();
        }
    }

    @Override
    public void updateDB() {
        FYPCoordinatorDB FYPDB = new FYPCoordinatorDB();

        reqDB.objectDB.add((new RegisterProjectRequest(reqDB.size+1, projID, fromUser, FYPDB.findInstance())).createRequest());
    }

    @Override
    public void getInput() throws InvalidInputException {
        
        ViewAvailableProjects projs = new ViewAvailableProjects(fromUser);

        // View Projects
		if (projs.projects.size() != 0) {

			System.out.printf("Select Project to register: ");
			projID = sc.nextInt();

			if (projs.projects.contains(projID)) {
                updateDB();
                exportDB();
                created = true;

			} else {
				throw new InvalidInputException(projID);
			}
		}
    }
}