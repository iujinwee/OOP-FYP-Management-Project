package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Request.EnactRequestController.EnactRequestController;
import Controller.Project.ModifyProjectController.ControllerObject.DeregisterProject;
import Entity.UserClass.Student;
import Entity.DatabaseClass.ProjectDB;
import Entity.ProjectClass.ProjectStatus;

public class EnactDeregisterProject extends EnactRequestController {

    public EnactDeregisterProject(int reqID){
        super(reqID);
    }
    
    @Override
    public void approve() {
        new DeregisterProject(request.getProjectID(), (Student) request.getFromUser());
    }

    @Override
    public void reject() {}
}