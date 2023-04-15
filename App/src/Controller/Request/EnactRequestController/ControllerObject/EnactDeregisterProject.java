package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Request.EnactRequestController.EnactRequestController;
import Controller.Project.ModifyProjectController.ControllerObject.DeregisterProject;
import Entity.DatabaseClass.StudentDB;
import Entity.UserClass.Student;

public class EnactDeregisterProject extends EnactRequestController {

    private StudentDB stuDB;

    public EnactDeregisterProject(int reqID){
        super(reqID);
    }
    
    @Override
    public void approve() {
        new DeregisterProject(request.getProjectID(), (Student) request.getFromUser());
        stuDB.findInstance(request.getfromUserID()).setAssigned(false);
        stuDB.exportDB();
    }

    @Override
    public void reject() {}
}