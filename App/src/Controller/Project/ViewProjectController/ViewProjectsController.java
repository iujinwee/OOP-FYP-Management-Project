package Controller.Project.ViewProjectController;

import java.util.ArrayList;

import Boundaries.Database.LoadFilesInterface;
import Boundaries.Project.ViewProjectInterface;
import Boundaries.Project.ViewProjectListInterface;
import Entity.DatabaseClass.ProjectDB;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;

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
    public int viewBasicProjectInfo(Project proj){
		System.out.printf("| %-10s | [%-2d] %s \n",  proj.getProjectStatus(), proj.getProjectID(), proj.getProjectTitle());
		return proj.getProjectID();
	}
    
    
    @Override
    public void viewFullProjectInfo(Project proj) {
        
       // View Project Details
       System.out.println("================================================================");
		System.out.println("| > Project");
		System.out.println("| Project ID: " + proj.getProjectID());
		System.out.println("| Project Title: " + proj.getProjectTitle());
		System.out.println("| Project Status: " + proj.getProjectStatus());
        System.out.println("================================================================");

		System.out.println("| > Supervisor-in-charge");
		System.out.println("| Supervisor Name: " + proj.getSupervisor().getName());
		System.out.println("| Supervisor Email: " + proj.getSupervisor().getEmail());
        System.out.println("================================================================");

        ProjectStatus status = proj.getProjectStatus();

		if((status == ProjectStatus.ALLOCATED) | (status == ProjectStatus.RESERVED)){
			System.out.println("| > Assigned Student");
			System.out.println("| Student Name: " + proj.getStudent().getName());
			System.out.println("| Student Email: " + proj.getStudent().getEmail());
            System.out.println("================================================================");
		}
    }
}
