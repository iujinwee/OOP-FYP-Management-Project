package Projects;

import Database.ProjectDB;
import Users.UserDetails.User;

public class ViewAvailableProjects extends ViewProjects{

    public ViewAvailableProjects(User user){
        initializeFiles();
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
						count += viewProject(curProj);
                    }
                    break;

                // Student can only access available projects 
                case STUDENT: 
                    if(curProj.getProjectStatus()==ProjectStatus.AVAILABLE){
						count += viewProject(curProj);
                    }
                    break;

                // FYP Coordinator can access all projects
                case FYPCOORDINATOR: 
					count += viewProject(curProj);
                    break;

                default:
                    System.out.println("No Projects Found!");
                    break;
            }
		}
    }
}
