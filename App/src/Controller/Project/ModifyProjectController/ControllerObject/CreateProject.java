package Controller.Project.ModifyProjectController.ControllerObject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.tools.ant.taskdefs.Input;

import Boundaries.Menu.ExceptionHandlerInterface;
import Boundaries.Menu.GetInputInterface;
import Controller.Project.ModifyProjectController.GetInputModifyProjectController;
import Controller.Project.ModifyProjectController.ModifyProjectController;
import Entity.ProjectClass.Project;
import Entity.UserClass.Supervisor;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public class CreateProject extends GetInputModifyProjectController{

	private Supervisor supervisor;
	private Project newProject;
	private String newTitle;

    public CreateProject(Supervisor supervisor){
		super();
        this.supervisor = supervisor;
		handleException();
    }

	
	@Override
	public void getInput() throws InvalidInputException {
        //ask rest of project details here
		//if num of assigned > 2 then cannot create project alr 
		//else num of assigned +1

		
		if (supervisor.getNumAssignedProjects() < 2) {
			while(handler.checkAttempts()){
				// Get Project Title
				System.out.printf("Input your new project title: ");
				newTitle = sc.nextLine();
				
				System.out.printf("Creating New Project: [%s] Confirm?\n", newTitle);
				System.out.println("[1] Yes");
				System.out.println("[0] No");
				System.out.printf("Enter option: ");
				int choice = sc.nextInt();

				if(choice==1){
					updateDB();
					System.out.printf("\nSuccessfully created Project - %s\n", newTitle);

				}else if(choice == 0){
					System.out.println("Creating New Project operation is cancelled.\n");
				}else{
					throw new InvalidInputException(choice);
				}
			}
		}
		else {
			System.out.println("Error! You are unable to create anymore projects!\n");
		}
	}


    @Override
    public void updateDB() {

		// Create new project
		int newID = ++projDB.size; 
		newProject = new Project(newID); 
		newProject.setSupervisor(supervisor); 
		newProject.setProjectTitle(newTitle);

		// Add to database
		projDB.objectDB.add(newProject);
		exportDB();
    }

}
