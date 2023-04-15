package Controller.Project.ModifyProjectController.ControllerObject;

import Controller.Project.ModifyProjectController.ModifyProjectController;
import Entity.DatabaseClass.SupervisorDB;
import Entity.UserClass.Supervisor;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;

public class ChangeProjectSupervisor extends ModifyProjectController {

    private int projID;
    private Supervisor supervisor;
    public SupervisorDB supDB;

    public ChangeProjectSupervisor(int projID, String supID) {
        super();

        SupervisorDB supDB = new SupervisorDB();
        this.projID = projID;
        this.supervisor = supDB.findInstance(supID);

        updateDB();
        exportDB();
    }

    @Override
    public void updateDB() {
        supDB = new SupervisorDB();
        if (supervisor.getNumAssignedProjects() >= 2) {
            System.out.println("New supervisor has reached project limit.");
        } 

        else {
            Supervisor oldSup = supDB.findInstance(projDB.findInstance(projID).getSupervisor().getUserID());
            oldSup.removeAssignedProjects();
            for (Object obj : projDB.objectDB) {
                Project curProject = (Project) obj;
                boolean own = oldSup.getUserID().compareTo(curProject.getSupervisorID())==0;
                boolean unavailable = curProject.getProjectStatus() == ProjectStatus.UNAVAILABLE;
                boolean Allocated = curProject.getProjectStatus() == ProjectStatus.ALLOCATED;
                if (own && unavailable && !Allocated) {
                    curProject.setProjectStatus(ProjectStatus.AVAILABLE);
                }
            }
            supervisor.addAssignedProjects();
            projDB.findInstance(projID).setSupervisor(supervisor);
            if (supervisor.getNumAssignedProjects() >= 2) {
                for (Object obj : projDB.objectDB) {
                    Project curProject = (Project) obj;
                    boolean own = supervisor.getUserID().compareTo(curProject.getSupervisorID())==0;
                    boolean available = curProject.getProjectStatus() == ProjectStatus.AVAILABLE;
                    if (own && available) {
                        curProject.setProjectStatus(ProjectStatus.UNAVAILABLE);
                    }
                }
            }
            supDB.exportDB();

            System.out.printf("Successfully changed supervisor to %s\n", supervisor.getName());
        }

    }
}
