package Boundaries.Project;

import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.UserDetails.User;

public class ViewAvailableProjects extends ViewProjects {

    /**
	 * View Available Projects Constructor.
	 * @param user User Object
	 */
    public ViewAvailableProjects(User user){
        super();
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

        for (Object obj: projDB.objectDB ){
			Project curProj = (Project) obj;

            switch(user.getUserType()) {
                // Supervisor can access his/ her own projects
                case SUPERVISOR: 
                    if(curProj.getSupervisorID().compareTo(user.getUserID())==0) {
						projects.add(curProj.viewBasicProjectInfo());
                    }
                    break;

                // Student can only access available projects 
                case STUDENT: 
                    if(curProj.getProjectStatus()==ProjectStatus.AVAILABLE) {
						projects.add(curProj.viewBasicProjectInfo());
                    }
                    break;

                // FYP Coordinator can access all projects
                case FYPCOORDINATOR: 
                    projects.add(curProj.viewBasicProjectInfo());
                    break;

                default:
                    System.out.println("Invalid User Type.");
                    break;
            }
		}
    }
}
