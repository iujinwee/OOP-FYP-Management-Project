package Controller.Request.EnactRequest;

import Controller.Project.ModifyProject.RegisterProject;
import Entity.UserClass.Student;
import Entity.UserClass.Supervisor;
import Entity.DatabaseClass.ProjectDB;
import Entity.DatabaseClass.StudentDB;
import Entity.DatabaseClass.SupervisorDB;
import Entity.ProjectClass.ProjectStatus;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;
import Entity.ProjectClass.*;

public class EnactRegisterProject extends EnactRequest {

    public EnactRegisterProject(int reqID) {
        super(reqID);
    }

    @Override
    public void approve() {
        StudentDB stuDB = new StudentDB();

        new RegisterProject(request.getProjectID(), (Student) request.getFromUser());
        stuDB.findInstance(request.getfromUserID()).setAssigned(true);
        stuDB.exportDB();

        SupervisorDB supDB = new SupervisorDB();
        ProjectDB projDB = new ProjectDB();
        Project curProject = projDB.findInstance(request.getProjectID());
        Supervisor curSup = supDB.findInstance(curProject.getSupervisorID());

        if (curSup.getNumAssignedProjects() >= 2) {
            for (Object obj : reqDB.objectDB) {
                Request curReq = (Request) obj;
                boolean isReg = curReq.getRequestType() == RequestType.REGISTERPROJECT;
                boolean own = (projDB.findInstance(curReq.getProjectID())).getSupervisorID()
                        .compareTo(curSup.getUserID()) == 0;
                boolean pending = curReq.getRequestStatus() == RequestStatus.PENDING;
                boolean notsame = curReq.getfromUserID().compareTo(request.getfromUserID()) != 0;
                if (isReg && own && pending && notsame) {
                    curReq.setRequestStatus(RequestStatus.REJECTED);
                }
            }
        }
    }

    @Override
    public void reject() {
        ProjectDB projDB = new ProjectDB();
        projDB.findInstance(request.getProjectID()).setProjectStatus(ProjectStatus.AVAILABLE);
        projDB.exportDB();
    }
}