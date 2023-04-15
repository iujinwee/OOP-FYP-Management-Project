package Controller.Project.GenerateProjectReportController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import Boundaries.Menu.BodyInterface;
import Controller.Project.ViewProjectController.ViewProjectsController;
import Entity.ProjectClass.Project;
import Entity.UserClass.Supervisor;

public class SupervisorReport extends ViewProjectsController implements BodyInterface{

    private Map<Supervisor, ArrayList<Project>> projectsBySupervisor;
    ArrayList<Supervisor> supervisors;

    private ArrayList<Project> availableProjs = new ArrayList<>(); 
    private ArrayList<Project> unavailableProjs = new ArrayList<>(); 
    private ArrayList<Project> reservedProjs = new ArrayList<>(); 
    private ArrayList<Project> allocatedProjs = new ArrayList<>(); 


    public SupervisorReport(){
        // Loading Status Report 
        super();
        sortProjectList();

        // Displaying Report
        title();
        body();
        footer();
    }
    
    public void title() {
        System.out.println("\nPROJECT REPORT (SUPERVISOR)");
        System.out.println("=========================");
    }

    @Override
    public void header(){
        System.out.println(String.format("%-4s %-85s %-10s %-15s %-15s", "ID", "Title", "Status", "Student", "Supervisor"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
 
    }

    @Override
    public void footer() {
        System.out.println("\n=========   END OF PROJECT REPORT  ===========\n");
    }
    private void sortProjectList(){
        // Group projects by supervisor
        projectsBySupervisor = new HashMap<>();
        for (Object o : projDB.objectDB) {
            Project project = (Project) o;
            if (!projectsBySupervisor.containsKey(project.getSupervisor())) {
                projectsBySupervisor.put(project.getSupervisor(), new ArrayList<>());
            }
            projectsBySupervisor.get(project.getSupervisor()).add(project);
        }
    
        supervisors= new ArrayList<>(projectsBySupervisor.keySet());
        // Sort projects by supervisor name
        supervisors.sort(Comparator.comparing(Supervisor::getName));
    
        // Store the sorted projects by status
        for (Supervisor supervisor : supervisors) {
            ArrayList<Project> projects = projectsBySupervisor.get(supervisor);
            for (Project project : projects) {
                switch (project.getProjectStatus()) {
                    case ALLOCATED:
                        allocatedProjs.add(project);
                        break;
                    case RESERVED:
                        reservedProjs.add(project);
                        break;
                    case AVAILABLE:
                        availableProjs.add(project);
                        break;
                    case UNAVAILABLE:
                        unavailableProjs.add(project);
                        break;
                }
            }
        }
    }
    
    @Override
    public void body() {
        String record = ""; 
        for (Supervisor supervisor : supervisors) {

            if(record.compareTo(supervisor.getName())!=0){
                System.out.println("\n\n=================================================================================================================================");
                System.out.println(String.format("Supervisor: %s", supervisor.getName()));
                System.out.println("=================================================================================================================================");
                header();
            }
            
            ArrayList<Project> projects = projectsBySupervisor.get(supervisor);
            printList(projects);

            record = supervisor.getName();
        }
     }
    
    private void printList(ArrayList<Project> arr){
        if(arr.size()!=0){
            for(Project p : arr){    
                String stu = p.getStudent().getName();
                if(stu==null){
                    stu = "< EMPTY >";
                } 
                System.out.println(String.format("%-4s %-85s %-10s %-15s %-15s", p.getProjectID(), p.getProjectTitle(), p.getProjectStatus(), stu, p.getSupervisor().getName()));
            }
        }        
    }
    
}
