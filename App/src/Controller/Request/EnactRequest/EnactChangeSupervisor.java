package Controller.Request.EnactRequest;

import Controller.Project.ModifyProject.ChangeProjectSupervisor;
import Entity.UserClass.Supervisor;
import Entity.ProjectClass.*;
import Entity.DatabaseClass.SupervisorDB;
import Entity.DatabaseClass.ProjectDB;

public class EnactChangeSupervisor extends EnactRequest {

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