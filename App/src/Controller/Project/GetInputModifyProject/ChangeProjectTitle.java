package Controller.Project.GetInputModifyProject;

import Boundaries.Project.ViewPersonalProjects;
import Entity.UserClass.Supervisor;
import Entity.ProjectClass.Project;
import Exceptions.InvalidInputException;

public class ChangeProjectTitle extends GetInputModifyProject{

    private int projID;
    private String newTitle;
    private Supervisor supervisor;

    /** 
     * Change Project Title Constructor.
     * @param sup Supervisor Object
     */
    public ChangeProjectTitle(Supervisor sup) {
        super();
        this.supervisor = sup;
        handleException();
    }

    /** 
     * Change Project Title Constructor.
     * @param projID Unique ID of Project Object
     * @param newTitle New Title of Project
     */
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
        boolean own = false;
        for (Object obj : projDB.objectDB) {
            Project curProject = (Project) obj;
            if (supervisor.getUserID().compareTo(curProject.getSupervisorID()) == 0) {
                own = true;
                break;
            }
            ;
        }

        if (!own) {
            System.out.println("\n==============================================");
		    System.out.println("========    Personal Project List     ========");
		    System.out.println("==============================================\n");
            System.out.println("=========     NO PROJECTS FOUND!     =========\n\n");
        }

        else {
            ViewPersonalProjects projs = new ViewPersonalProjects(supervisor);

            System.out.println("Select Project ID to change new title:");
            projID = sc.nextInt();
            sc.nextLine();

            own = projs.projects.contains(projID);

            if (own) {
                System.out.printf("Enter the new title: ");
                newTitle = sc.nextLine();

                if(newTitle.isBlank()){
                    System.out.println("\nTitle cannot be empty!\n");
                }
                
                else{
                    System.out.println("\nChanging Project Title:");
                    System.out.printf("Current: %s\n", projDB.findInstance(projID).getProjectTitle());
                    System.out.printf("New: %s\n", newTitle);
                    System.out.println("\nConfirm?");
    
                    System.out.println("[1] Yes");
                    System.out.println("[0] No");
                    System.out.printf("Enter option: ");
                    int choice = sc.nextInt();
    
                    if (choice == 1) {
                        updateDB();
                        System.out.printf("\nSuccessfully changed title to %s!\n\n", newTitle);
    
                    } else if (choice == 0) {
                        System.out.println("Creating New Project operation is cancelled.\n");
                    } else {
                        throw new InvalidInputException(choice);
                    }
    
                }

               
            } else {
                throw new InvalidInputException(projID);
            }
        }
    }
}
