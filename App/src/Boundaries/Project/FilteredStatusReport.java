package Boundaries.Project;

import java.util.ArrayList;

import Boundaries.Menu.Interfaces.BodyInterface;
import Boundaries.Menu.Interfaces.FooterInterface;
import Boundaries.Menu.Interfaces.HeaderInterface;
import Controller.Project.LoadProjectDB;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;

public class FilteredStatusReport extends LoadProjectDB implements HeaderInterface, BodyInterface, FooterInterface {
    
    private ProjectStatus status;
    private ArrayList<Project> projectsList = new ArrayList<>();

    /**
	 * Filtered Status Report Constructor.
	 * @param status Status of Project
	 */
    public FilteredStatusReport(ProjectStatus status){ 
        // Loading Status Report 
        super(); 
        this.status = status;
        
        // Sorting Project List 
        sortProjectList();

        // Displaying Report
        header();
        body();
        footer();
    }

    @Override
    public void header() {
        System.out.printf("\nPROJECT REPORT (%s)\n", status.toString());
        System.out.println("=========================");
        System.out.println(String.format("%-4s %-85s %-10s %-15s %-15s", "ID", "Title", "Status", "Student", "Supervisor"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void body() {
        if((projectsList != null ) || (projectsList.size()!=0)){
            printList(projectsList);
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("----------------------------------------                  Total: %d                 ---------------------------------------------\n", projectsList.size());
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        }
    }
        
    
    @Override
    public void footer() {
        if ((projectsList == null) || (projectsList.size()==0)) {
			System.out.println("\n==============================================   NO PROJECTS FOUND!   ==============================================\n");
		} else {
			System.out.println("\n==============================================   END OF PROJECT REPORT   ==============================================\n");
		}
    }

    /**
	 * Method used to sort a list of projects.
	 */
    private void sortProjectList() {
        for(Object obj : projDB.objectDB){
            Project p = (Project) obj;
            if(p.getProjectStatus().compareTo(status)==0){
                projectsList.add(p);
            }
        }
    }

    
    /** 
     * Method used to print an array list of projects.
     * @param arr Array list of Project Objects
     */
    private void printList(ArrayList<Project> arr){
        if(arr.size()!=0){
            for(Project p : arr){    
                String stuName = p.getStudent().getName();
                if (stuName == null){
                    stuName = "< EMPTY >";
                }
                System.out.println(String.format("%-4s %-85s %-10s %-15s %-15s", p.getProjectID(), p.getProjectTitle(), p.getProjectStatus(), stuName , p.getSupervisor().getName()));
            }
        }        
    }
}
