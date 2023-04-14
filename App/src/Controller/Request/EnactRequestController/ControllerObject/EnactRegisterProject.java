package Controller.Request.EnactRequestController.ControllerObject;

import Controller.Request.EnactRequestController.EnactRequestController;
import Controller.Project.ModifyProjectController.ControllerObject.RegisterProject;
import Entity.UserClass.Student;
import Entity.DatabaseClass.ProjectDB;
import Entity.DatabaseClass.StudentDB;
import Entity.ProjectClass.ProjectStatus;

public class EnactRegisterProject extends EnactRequestController {

    private StudentDB stuDB;
    public EnactRegisterProject(int reqID){
        super(reqID);
    }

    @Override
    public void approve() {
        new RegisterProject(request.getProjectID(), (Student) request.getFromUser());
        stuDB.findInstance(request.getfromUserID()).setAssigned(true);
        stuDB.exportDB();
    }

    @Override
    public void reject() {
        ProjectDB projDB = new ProjectDB();
        projDB.findInstance(request.getProjectID()).setProjectStatus(ProjectStatus.AVAILABLE);
        projDB.exportDB();
    }
}