package Controller.Project.ModifyProjectController.ControllerObject;
import java.util.Scanner;

import Controller.Project.ModifyProjectController.GetInputModifyProjectController;
import Controller.Project.ViewProjectController.ControllerObject.ViewPersonalProjects;
import Entity.DatabaseClass.SupervisorDB;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.FYP_Coordinator;
import Entity.UserClass.Supervisor;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;


public class ChangeProjectSupervisor extends GetInputModifyProjectController {

    private int projID;
    private Supervisor supervisor;
    public SupervisorDB supDB = new SupervisorDB();
    private FYP_Coordinator FYP_coordinator; 
    String newSupervisor;
    public Scanner sc = new Scanner(System.in);

    
    public ChangeProjectSupervisor(int projID, String supID){
        super();
        
        SupervisorDB supDB = new SupervisorDB();
        this.projID = projID;
        this.supervisor = supDB.findInstance(supID);

        updateDB();
        exportDB();
    }

    public ChangeProjectSupervisor(FYP_Coordinator coordinator) {
        super(); 
        this.FYP_coordinator =  coordinator; 
        handleException(); 
        
        updateDB();
        exportDB();
    }
    
    @Override
    public void getInput() throws InvalidInputException {
        ViewPersonalProjects projs = new ViewPersonalProjects(FYP_coordinator);

        // View Projects
		if (projs.projects.size() != 0) {

			System.out.printf("Select Project ID to change new supervisor: ");
            this.projID = sc.nextInt();	

            // Check for invalid project ID
            if(!projs.projects.contains(projID)) {
                throw new InvalidInputException(projID);
            }
    
            // View Info
            projs.projDB.findInstance(projID).viewFullProjectInfo();
            
 

			boolean allocated = (projs.projDB.findInstance(projID).getProjectStatus() == ProjectStatus.ALLOCATED);

            if(allocated) {
			
                boolean proceed = false;
                supDB.view();

                handleInvalidInput handler = new handleInvalidInput(3);

                // Provide 3 attempts to enter supervisor ID
                while(handler.checkAttempts()) {
                    try {
                        System.out.printf("\nEnter New Supervisor ID: ");
                        newSupervisor = sc.next();
        
                        // Check for invalid supervisor ID
                        if(supDB.findInstance(newSupervisor).getUserID()==null) {
                            throw new InvalidInputException(newSupervisor);
                        } else {
                            proceed = true;
                            this.supervisor = supDB.findInstance(newSupervisor); 
                            break;
                        }

                    } catch(InvalidInputException e) {
                        handler.handleInvalidInputException(e);
                    }
                }

                if(proceed) {
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
   
    @Override
	public void updateDB() {		
        supDB = new SupervisorDB();
        supDB.findInstance(projDB.findInstance(projID).getSupervisor().getUserID()).removeAssignedProjects();
        supDB.findInstance(supervisor.getUserID()).addAssignedProjects();
        supDB.exportDB();
        projDB.findInstance(projID).setSupervisor(supervisor);

        System.out.printf("Successfully changed supervisor to %s\n", supervisor.getName());
	}
}
