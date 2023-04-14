package Controller.Project.ViewProjectController.ControllerObject;

import Controller.Project.ViewProjectController.ViewProjectsController;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.UserDetails.User;

public class ViewAvailableProjects extends ViewProjectsController{

    public ViewAvailableProjects(User user){
        loadFiles();
        header();
        body(user);
        footer();
    }

    @Override
    public void header() {
        System.out.println("\n===============================================");
		System.out.println("=========    Available Project List     =======");
		System.out.println("===============================================\n");
    }

    @Override
    public void body(User user) {

        for (Object obj: projDB.objectDB){
			Project curProj = (Project) obj;

            switch(user.getUserType()){
                // Supervisor can access his/ her own projects
                case SUPERVISOR: 
                    if(curProj.getSupervisorID().compareTo(user.getUserID())==0){
						projects.add(curProj.getProjectID());
                        viewBasicProjectInfo(curProj);
                    }
                    break;

                // Student can only access available projects 
                case STUDENT: 
                    if(curProj.getProjectStatus()==ProjectStatus.AVAILABLE){
						projects.add(curProj.getProjectID());
                        viewBasicProjectInfo(curProj);
                    }
                    break;

                // FYP Coordinator can access all projects
                case FYPCOORDINATOR: 
                    projects.add(curProj.getProjectID());
                    viewBasicProjectInfo(curProj);
                    break;

                default:
                    System.out.println("No Projects Found!");
                    break;
            }
		}
    }
}
