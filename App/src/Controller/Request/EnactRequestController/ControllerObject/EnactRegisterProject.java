package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Request.EnactRequestController.EnactRequestController;
import Controller.Project.ModifyProjectController.ControllerObject.RegisterProject;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.UserClass.Student;

public class EnactRegisterProject extends EnactRequestController {

    public EnactRegisterProject(int reqID){
        super(reqID);
    }

    @Override
    public void approve() {
        new RegisterProject(request.getProjectID(), (Student) request.getFromUser());
    }

    @Override
    public void reject() {}
}