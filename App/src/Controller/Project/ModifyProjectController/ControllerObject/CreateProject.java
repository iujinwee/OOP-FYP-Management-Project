package Controller.Project.ModifyProjectController.ControllerObject;

import Controller.Project.ModifyProjectController.ModifyProjectController;
import Entity.ProjectClass.Project;
import Entity.UserClass.Supervisor;

public class CreateProject extends ModifyProjectController {

    private Supervisor supervisor;

    public CreateProject(Supervisor supervisor) {
		super();
        this.supervisor = supervisor;
        updateDB();
        exportDB();
    }

    @Override
    public void updateDB() {
        //ask rest of project details here
		//if num of assigned > 2 then cannot create project alr 
		//else num of assigned +1
		if (this.supervisor.getNumAssignedProjects() < 2) {
			int newID = ++projDB.size; 
			Project newProject = new Project(newID); // Default 
			newProject.setSupervisor(supervisor); 

			// Get Project Title
			System.out.println("Input your project title:");
			String title = projDB.sc.next();
			
			// Export database
			newProject.setProjectTitle(title);
			projDB.objectDB.add(newProject);
		} else {
			System.out.println("Error! You are unable to create anymore projects!");
		}
    }
}
