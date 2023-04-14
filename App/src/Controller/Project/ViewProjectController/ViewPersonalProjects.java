package Controller.Project.ViewProjectController;

import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
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
			boolean own = curProj.getStudentID().compareTo(user.getUserID())==0;
			boolean allocated = curProj.getProjectStatus().compareTo(ProjectStatus.ALLOCATED)==0;

			if (curProj.getStudent()==null){
				break;
			}

			switch(user.getUserType()){
				case STUDENT: 
					if(own && allocated){
						projects.add(curProj.getProjectID());
						viewFullProjectInfo(curProj);
					}	
					break;

				case SUPERVISOR:
				case FYPCOORDINATOR:

					if(own){
						projects.add(curProj.getProjectID());
						viewBasicProjectInfo(curProj);
					}
					break;
					
				default: 
					break;
			}
		}
    }
}