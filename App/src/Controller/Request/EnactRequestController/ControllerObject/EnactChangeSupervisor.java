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
        new ChangeProjectSupervisor(request.getProjectID(), request.getNewSupervisor());
    }

    @Override
    public void reject() {}
}