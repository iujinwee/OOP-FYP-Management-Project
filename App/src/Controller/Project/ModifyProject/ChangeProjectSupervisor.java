package Controller.Project.ModifyProject;

import Boundaries.Project.ViewPersonalProjects;
import Controller.Project.GetInputModifyProject.GetInputModifyProject;
import Entity.DatabaseClass.SupervisorDB;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.FYP_Coordinator;
import Entity.UserClass.Supervisor;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public class ChangeProjectSupervisor extends GetInputModifyProject {

    private int projID;
    private Supervisor supervisor;
    private SupervisorDB supDB = new SupervisorDB();
    private FYP_Coordinator FYP_coordinator; 
    String newSupervisor;

    /** 
     * Change Project Supervisor Constructor. As per request from Supervisor to FYP Coordinator.
     * @param projID Unique ID of Project Object
     * @param supID Unique ID of Supervisor Object
     */
    public ChangeProjectSupervisor(int projID, String supID){
        super();
        this.projID = projID;
        this.supervisor = supDB.findInstance(supID);

        updateDB();
        exportDB();
    }

    /**
     * Change Project Supervisor Constructor. Directly from the FYP Coordinator.
     * @param coordinator FYP Coordinator Object
     */
    public ChangeProjectSupervisor(FYP_Coordinator coordinator) {
        super(); 
        this.FYP_coordinator = coordinator; 
        handleException(); 
        
        if(supervisor != null){
            updateDB();
            exportDB();
        }
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
            
			boolean allocated = projs.projDB.findInstance(projID).getProjectStatus().compareTo(ProjectStatus.ALLOCATED)==0;

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

        

        if (supervisor.getNumAssignedProjects() >= 2) {
            System.out.println("New supervisor has reached project limit.");
        } 

        else {
            Supervisor oldSup = supDB.findInstance(projDB.findInstance(projID).getSupervisor().getUserID());
            oldSup.removeAssignedProjects();
            for (Object obj : projDB.objectDB) {
                Project curProject = (Project) obj;
                boolean own = oldSup.getUserID().compareTo(curProject.getSupervisorID())==0;
                boolean unavailable = curProject.getProjectStatus() == ProjectStatus.UNAVAILABLE;
                boolean Allocated = curProject.getProjectStatus() == ProjectStatus.ALLOCATED;
                if (own && unavailable && !Allocated) {
                    curProject.setProjectStatus(ProjectStatus.AVAILABLE);
                }
            }
            supervisor.addAssignedProjects();
            projDB.findInstance(projID).setSupervisor(supervisor);
            if (supervisor.getNumAssignedProjects() >= 2) {
                for (Object obj : projDB.objectDB) {
                    Project curProject = (Project) obj;
                    boolean own = supervisor.getUserID().compareTo(curProject.getSupervisorID())==0;
                    boolean available = curProject.getProjectStatus() == ProjectStatus.AVAILABLE;
                    if (own && available) {
                        curProject.setProjectStatus(ProjectStatus.UNAVAILABLE);
                    }
                }
            }
            supDB.exportDB();

            System.out.printf("Successfully changed supervisor to %s\n", supervisor.getName());
        }

    }
}
