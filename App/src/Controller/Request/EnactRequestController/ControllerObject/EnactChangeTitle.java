package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Request.EnactRequestController.EnactRequestController;
import Controller.Project.ModifyProjectController.ControllerObject.ChangeProjectTitle;

public class EnactChangeTitle extends EnactRequestController {

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