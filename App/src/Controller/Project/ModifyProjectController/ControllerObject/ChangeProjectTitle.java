package Controller.Project.ModifyProjectController.ControllerObject;

import Boundaries.Project.Classes.ViewPersonalProjects;
import Controller.Project.ModifyProjectController.GetInputModifyProjectController;
import Entity.UserClass.Supervisor;
import Exceptions.InvalidInputException;

public class ChangeProjectTitle extends GetInputModifyProjectController{

    private int projID;
    private String newTitle;
    private Supervisor supervisor;

    public ChangeProjectTitle(Supervisor sup){
        super();
        this.supervisor = sup;
        handleException();
    }
    
    public ChangeProjectTitle(int projID, String newTitle) {
        super();

        this.projID = projID;
        this.newTitle = newTitle;
        updateDB();
    }
    
    @Override
	public void updateDB() {
		projDB.findInstance(projID).setProjectTitle(newTitle);
        exportDB();
	}

    @Override
    public void getInput() throws InvalidInputException {
        ViewPersonalProjects projs = new ViewPersonalProjects(supervisor);

        System.out.println("Select Project ID to change new title:");
		int projID = sc.nextInt();
        
		boolean own = projs.projects.contains(projID);

		if(own){	
			System.out.printf("Enter the new title: ");
			newTitle = sc.next();
				
            System.out.println("\nChanging Project Title:");
            System.out.printf("Current: %s\n", projDB.findInstance(projID).getProjectTitle());
            System.out.printf("New: %s\n", newTitle);
            System.out.println("\nConfirm?");
            
            System.out.println("[1] Yes");
            System.out.println("[0] No");
            System.out.printf("Enter option: ");
            int choice = sc.nextInt();

            if(choice==1){
                updateDB();
                System.out.printf("\nSuccessfully changed title to %s!\n\n", newTitle);

            }else if(choice == 0){
                System.out.println("Creating New Project operation is cancelled.\n");
            }else{
                throw new InvalidInputException(choice);
            }

		}else{
			throw new InvalidInputException(projID);
		}
    }
}
