package Controller.Project.ViewProjectController;

import Entity.ProjectClass.Project;
import Entity.UserClass.UserDetails.*;

public class ViewPersonalProjects extends ViewProjectsController{

    public ViewPersonalProjects(User user){
		loadFiles();
        header();
        body(user);
        footer();
    }

    @Override
    public void header() {
        System.out.println("\n==============================================");
		System.out.println("========    Personal Project List     ========");
		System.out.println("==============================================\n");
    }

    @Override
    public void body(User user) {

        for (Object obj: projDB.objectDB){
			
			Project curProj = (Project) obj;

			if (curProj.getStudent()==null){
				break;
			}

			switch(user.getUserType()){
				case STUDENT: 

					if(curProj.getStudentID().compareTo(user.getUserID())==0){
						projects.add(viewProject(curProj));
						break;
					}	
				case SUPERVISOR:
				case FYPCOORDINATOR:

					if(curProj.getSupervisorID().compareTo(user.getUserID())==0){
						projects.add(viewProject(curProj));
						break;
					}
				default: 
					break;
			}
		}
    }
}
