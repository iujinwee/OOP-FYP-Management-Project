package Controller.Request.EnactRequest;

import Controller.Project.ModifyProject.DeregisterProject;
import Entity.DatabaseClass.StudentDB;
import Entity.UserClass.Student;

public class EnactDeregisterProject extends EnactRequest {

    public EnactDeregisterProject(int reqID){
        super(reqID);
    }
    
    @Override
    public void approve() {
        StudentDB stuDB = new StudentDB();

        new DeregisterProject(request.getProjectID(), (Student) request.getFromUser());
        stuDB.findInstance(request.getfromUserID()).setAssigned(false);
        stuDB.exportDB();
    }

    @Override
    public void reject() {}
}