package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Request.EnactRequestController.EnactRequestController;
import Controller.Project.ModifyProjectController.ControllerObject.DeregisterProject;
import Entity.RequestClass.RequestStatus;
import Entity.UserClass.Student;

public class EnactDeregisterProject extends EnactRequestController {

    Student dereg = (Student) request.getFromUser();

    public EnactDeregisterProject(int reqID){
        super(reqID);
    }
    
    @Override
    public void approve() {
        new DeregisterProject(request.getProjectID(), dereg);
    }

    @Override
    public void reject() {
        projDB.findInstance(request.getProjectID()).addRejected(dereg.getUserID());
    }
}