package Projects;

import Database.ProjectDB;

public abstract class ViewProjects implements ProjectInterface, ViewProjectInterface {
    
    public int count;
	public ProjectDB projDB;

    @Override
    public void initializeFiles() {
        System.out.println("\nInitializing ProjectDB...");
        projDB = new ProjectDB();
        System.out.println("ProjectDB Initialized.\n");
    }

    @Override
    public void footer() {
        if(count == 0){
			System.out.println("=======     NO PROJECTS FOUND!     =======");
		}else{
			System.out.println("\n=========   END OF PROJECT LIST  ===========\n");
		}
    }

    @Override
    public int viewProject(Project proj){
		System.out.printf("%s | [%d] %s \n",  proj.getProjectStatus(), proj.getProjectID(), proj.getProjectTitle());
		return 1;
	}
    
}
