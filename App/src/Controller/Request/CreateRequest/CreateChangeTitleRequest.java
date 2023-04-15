package Controller.Request.CreateRequest;

import Boundaries.Project.ViewPersonalProjects;
import Entity.DatabaseClass.FYP_CoordinatorDB;
import Entity.RequestClass.RequestType;
import Entity.RequestClass.RequestSubClass.ChangeTitleRequest;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;

public class CreateChangeTitleRequest extends CreateRequest{

    FYP_CoordinatorDB FYPDB = new FYP_CoordinatorDB();
    String newTitle;

    public CreateChangeTitleRequest(User user){
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
            newTitle = sc.nextLine();
            
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