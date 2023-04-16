package Controller.Request.EnactRequest;

import Controller.Project.GetInputModifyProject.ChangeProjectTitle;

public class EnactChangeTitle extends EnactRequest {

    /** 
     * Enact Change Title Constructor.
     * @param reqID Unique ID of Request Object
     */
    public EnactChangeTitle(int reqID){
        super(reqID);
    }

    @Override
    public void approve() {
        new ChangeProjectTitle(request.getProjectID(), request.getNewTitle());
    }

    @Override
    public void reject() {}
}