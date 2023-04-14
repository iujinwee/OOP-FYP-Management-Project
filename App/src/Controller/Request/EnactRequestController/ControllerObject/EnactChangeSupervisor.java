package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Project.ModifyProjectController.ControllerObject.ChangeProjectSupervisor;
import Controller.Request.EnactRequestController.EnactRequestController;
import Entity.UserClass.Supervisor;
import Entity.ProjectClass.*;
import Entity.DatabaseClass.SupervisorDB;
import Entity.DatabaseClass.ProjectDB;

public class EnactChangeSupervisor extends EnactRequestController {

    public EnactChangeSupervisor(int reqID){
        super(reqID);
    }

    @Override
    public void approve() {
        SupervisorDB supDB = new SupervisorDB();
        if(supDB.findInstance(request.getNewSupervisor()).getNumAssignedProjects() < 2){
            new ChangeProjectSupervisor(request.getProjectID(), request.getNewSupervisor());
            if(supDB.findInstance(request.getNewSupervisor()).getNumAssignedProjects() == 2){
                ProjectDB projDB = new ProjectDB();
                for (Object obj : projDB.objectDB) {
                    Project curProject = (Project) obj;
                    if (supDB.findInstance(request.getNewSupervisor()).getUserID().compareTo(curProject.getSupervisorID())==0 && curProject.getProjectStatus() == ProjectStatus.AVAILABLE) {
                        curProject.setProjectStatus(ProjectStatus.UNAVAILABLE); // TO CHANGE
                    }
                }
            }
            Supervisor oldSup = supDB.findInstance(request.gettoUserID());
            for(Object obj : projDB.objectDB){
                Project curProject = (Project) obj;
                if(oldSup.getUserID().compareTo(curProject.getSupervisorID())==0 && curProject.getProjectStatus() == ProjectStatus.UNAVAILABLE){
                    curProject.setProjectStatus(ProjectStatus.AVAILABLE);
                }
            }
        }
        else{
            System.out.println("New supervisor has reached project limit.");
        }
    }

    @Override
    public void reject() {}
}