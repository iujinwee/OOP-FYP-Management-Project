package Controller.Request.CreateRequest;

import java.util.Scanner;

import Boundaries.Project.ViewAvailableProjects;
import Entity.DatabaseClass.FYP_CoordinatorDB;
import Entity.RequestClass.RequestType;
import Entity.RequestClass.RequestSubClass.RegisterProjectRequest;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public class CreateRegisterRequest extends CreateRequest{

    handleInvalidInput handler = new handleInvalidInput();
    Scanner sc = new Scanner(System.in);

    /** 
     * Create Register Request Constructor.
     * @param user User Object
     */
    public CreateRegisterRequest(User user){
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
        FYP_CoordinatorDB FYPDB = new FYP_CoordinatorDB();

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
