package Controller.Request.EnactRequest;

import Controller.Project.GetInputModifyProject.ChangeProjectTitle;

public class EnactChangeTitle extends EnactRequest {

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