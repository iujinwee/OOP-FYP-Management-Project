package Controller.Request.EnactRequest;

import Controller.Project.ModifyProject.ChangeProjectSupervisor;

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