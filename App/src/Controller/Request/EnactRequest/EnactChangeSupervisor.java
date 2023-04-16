package Controller.Request.EnactRequest;

import Controller.Project.ModifyProject.ChangeProjectSupervisor;

public class EnactChangeSupervisor extends EnactRequest {

    /** 
     * Enact Change Supervisor Constructor.
     * @param reqID Unique ID of Request Object
     */
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