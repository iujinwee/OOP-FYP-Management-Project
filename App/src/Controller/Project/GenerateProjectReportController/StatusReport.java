package Controller.Project.GenerateProjectReportController;

import java.util.ArrayList;

import Controller.Project.ViewProjectController.ViewProjectsController;
import Entity.ProjectClass.Project;
import Entity.UserClass.UserDetails.User;

public class StatusReport extends ViewProjectsController{

    private ArrayList<Project> availableProjs = new ArrayList<>(); 
    private ArrayList<Project> unavailableProjs = new ArrayList<>(); 
    private ArrayList<Project> reservedProjs = new ArrayList<>(); 
    private ArrayList<Project> allocatedProjs = new ArrayList<>(); 

    public StatusReport(){
        // Loading Status Report 
        loadFiles();
        sortProjectList();

        // Displaying Report
        header();
        body(null);
        footer();
    }
    
    @Override
    public void header() {
        System.out.println("PROJECT REPORT (STATUS)");
        System.out.println("=========================");
        System.out.println(String.format("%-4s %-85s %-10s %-15s %-15s", "ID", "Title", "Status", "Student", "Supervisor"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void body(User user) {
        printList(allocatedProjs);
        printList(reservedProjs);
        printList(availableProjs);
        printList(unavailableProjs);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("Total: %-4d | Allocated: %-5d | Reserved: %-5d | Available: %-5d | Unavailable: %-5d ", projDB.size, allocatedProjs.size(), reservedProjs.size(), availableProjs.size(), unavailableProjs.size()));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

    }

    @Override
    public void footer() {
        if(projects.size()!=0){
			System.out.println("=======     NO PROJECTS FOUND!     =======");
		}else{
			System.out.println("\n=========   END OF PROJECT REPORT  ===========\n");
		}
    }

    private void sortProjectList(){
        for(Object obj : projDB.objectDB){
            Project p = (Project) obj;
            switch(p.getProjectStatus()){
                case ALLOCATED:
                    allocatedProjs.add(p);
                    break;

                case AVAILABLE:
                    availableProjs.add(p);
                    break;

                case UNAVAILABLE: 
                    unavailableProjs.add(p);
                    break;

                case RESERVED: 
                    reservedProjs.add(p);
                    break;

            }
        }
    }

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
