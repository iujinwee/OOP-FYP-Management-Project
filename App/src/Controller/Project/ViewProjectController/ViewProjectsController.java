package Controller.Project.ViewProjectController;

import java.util.ArrayList;

import Boundaries.Database.LoadFilesInterface;
import Boundaries.Project.ViewProjectInterface;
import Boundaries.Project.ViewProjectListInterface;
import Entity.DatabaseClass.ProjectDB;
import Entity.ProjectClass.Project;

public abstract class ViewProjectsController implements LoadFilesInterface, ViewProjectListInterface, ViewProjectInterface {
    
    public ArrayList<Integer> projects = new ArrayList<>();
	public ProjectDB projDB;

    @Override
    public void loadFiles() {
        System.out.println("\nInitializing ProjectDB...");
        projDB = new ProjectDB();
        System.out.println("ProjectDB Initialized.\n");
    }

    @Override
    public void footer() {
        if(projects.size()==0){
			System.out.println("=======     NO PROJECTS FOUND!     =======");
		}else{
			System.out.println("\n=========   END OF PROJECT LIST  ===========\n");
		}
    }

    @Override
    public int viewProject(Project proj){
		System.out.printf("%s | [%d] %s \n",  proj.getProjectStatus(), proj.getProjectID(), proj.getProjectTitle());
		return proj.getProjectID();
	}
    
}
