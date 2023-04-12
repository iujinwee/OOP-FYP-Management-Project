package Projects.ViewProjectsPackage;

import Projects.Project;
import Users.UserDetails.User;

public class ViewPersonalProjects extends ViewProjects{

    public ViewPersonalProjects(User user){
		initializeFiles();
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
						count += viewProject(curProj);
						break;
					}	
				case SUPERVISOR:
				case FYPCOORDINATOR:

					if(curProj.getSupervisorID().compareTo(user.getUserID())==0){
						count += viewProject(curProj);
						break;
					}
				default: 
					break;
			}
		}
    }
}
