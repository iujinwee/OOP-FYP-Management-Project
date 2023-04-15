package Controller.Request.CreateRequestController.ControllerObject;

import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Controller.Request.CreateRequestController.NewRequestController;
import Entity.DatabaseClass.FYPCoordinatorDB;
import Entity.DatabaseClass.SupervisorDB;
import Entity.ProjectClass.ProjectStatus;
import Entity.RequestClass.RequestType;
import Entity.RequestClass.RequestSubClass.ChangeSupervisorRequest;
import Entity.UserClass.UserDetails.User;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public class NewChangeSupervisorRequest extends NewRequestController{

    FYPCoordinatorDB FYPDB = new FYPCoordinatorDB();
    SupervisorDB supDB = new SupervisorDB();
    String newSupervisor;

    public NewChangeSupervisorRequest(User user){
        super(user);
        this.type = RequestType.CHANGESUPERVISOR;

        header();
        body();
        
        if(created){
            footer();
        }
    }

    @Override
    public void updateDB() {
        reqDB.objectDB.add((new ChangeSupervisorRequest(reqDB.size+1, projID, fromUser, FYPDB.findInstance(), newSupervisor)).createRequest());
    }

    @Override
    public void getInput() throws InvalidInputException {
        
        ViewPersonalProjects projs = new ViewPersonalProjects(fromUser);

        // View Projects
		if (projs.projects.size() != 0) {

			System.out.printf("Select Project ID to change new supervisor: ");
            int projID = sc.nextInt();	
            // View Info
            projs.projDB.findInstance(projID).viewFullProjectInfo();
            
            // Check for invalid project ID
            if(!projs.projects.contains(projID)){
                throw new InvalidInputException(projID);
            }

			boolean allocated = (projs.projDB.findInstance(projID).getProjectStatus() == ProjectStatus.ALLOCATED);

            if(allocated){
			
                boolean proceed = false;
                supDB.view();

                handleInvalidInput handler = new handleInvalidInput(3);

                // Provide 3 attempts to enter supervisor ID
                while(handler.checkAttempts()){
                    try{
                        System.out.printf("\nEnter New Supervisor ID: ");
                        newSupervisor = sc.next();
        
                        // Check for invalid supervisor ID
                        if(supDB.findInstance(newSupervisor).getUserID()==null){
                            throw new InvalidInputException(newSupervisor);
                        }else{
                            proceed = true;
                            break;
                        }

                    }catch(InvalidInputException e){
                        handler.handleInvalidInputException(e);
                    }
                }

                if(proceed){
                    System.out.printf("\nChange Supervisor of Project %d to [%s]?\n", projID, newSupervisor);
                    System.out.println("[1] Yes");
                    System.out.println("[0] No");
                    System.out.printf("\nEnter Option: ");
                    int choice = sc.nextInt();
                    System.out.println("");
                    
                    if(choice == 1){
                        updateDB();
                        exportDB();
                    }else if(choice == 0){
                        System.out.println("\nChange Supervisor Request was cancelled.\n");
                    }else{
                        throw new InvalidInputException();
                    }
                }
            }else{
                System.out.println("The Project has not been allocated to a student!\n");
            }           
		}
    }
}