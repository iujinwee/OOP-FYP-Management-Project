package Boundaries.Project;

import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.UserDetails.*;

public class ViewPersonalProjects extends ViewProjects {

	/**
	 * View Personal Projects Constructor.
	 * @param user User Object
	 */
    public ViewPersonalProjects(User user){
		super();
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

        for (Object obj: projDB.objectDB) {
			
			Project curProj = (Project) obj;
			boolean allocated = curProj.getProjectStatus().compareTo(ProjectStatus.ALLOCATED)==0;

			if (curProj.getStudent()==null) {
				break;
			}

			switch(user.getUserType()) {
				case STUDENT: 
					boolean own = curProj.getStudentID().compareTo(user.getUserID())==0;
					if(own && allocated){
						projects.add(curProj.viewFullProjectInfo());
					}	
					break;

				case SUPERVISOR:
				case FYPCOORDINATOR:
				boolean created = curProj.getSupervisorID().compareTo(user.getUserID())==0;
					if(created) {
						projects.add(curProj.viewBasicProjectInfo());
					}
					break;
					
				default: 
					break;
			}
		}
    }
}
