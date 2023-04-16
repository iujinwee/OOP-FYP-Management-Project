package Controller.Project.ModifyProject;

import Entity.DatabaseClass.SupervisorDB;
import Entity.DatabaseClass.RequestDB;
import Entity.ProjectClass.Project;
import Entity.ProjectClass.ProjectStatus;
import Entity.UserClass.Student;
import Entity.UserClass.Supervisor;
import Entity.RequestClass.Request;
import Entity.RequestClass.RequestStatus;
import Entity.RequestClass.RequestType;

public class RegisterProject extends ModifyProject {

    private int projID;
    private Student student;
    
    public RegisterProject(int projID, Student student) {
        super();
        this.projID = projID;
        this.student = student;
        updateDB();
        exportDB();
    }
    
    @Override
	public void updateDB() {		

        // Allocate student
        Project currentProj = projDB.findInstance(projID);
        
        currentProj.setStudent(student);
        currentProj.setProjectStatus(ProjectStatus.ALLOCATED);

        SupervisorDB supDB = new SupervisorDB();
        Supervisor curSup = supDB.findInstance(currentProj.getSupervisor().getUserID());
        curSup.addAssignedProjects();

        RequestDB reqDB = new RequestDB();

        if(curSup.getNumAssignedProjects() >= 2){

            for(Object obj : reqDB.objectDB){
                Request curReq = (Request) obj;
                boolean isReg = curReq.getRequestType() == RequestType.REGISTERPROJECT;
                boolean own = (projDB.findInstance(curReq.getProjectID())).getSupervisorID().compareTo(curSup.getUserID())==0;
                boolean pending = curReq.getRequestStatus() == RequestStatus.PENDING;
                boolean notsame = curReq.getfromUserID().compareTo(student.getUserID())!= 0;
                if(isReg && own && pending && notsame){
                    projDB.findInstance(curReq.getProjectID()).setProjectStatus(ProjectStatus.AVAILABLE);
                    projDB.exportDB();
                }
            }

            for (Object obj : projDB.objectDB) {
                Project curProject = (Project) obj;
                boolean own = curSup.getUserID().compareTo(curProject.getSupervisorID())==0;
                boolean available = curProject.getProjectStatus() == ProjectStatus.AVAILABLE;
                if (own && available) {
                    curProject.setProjectStatus(ProjectStatus.UNAVAILABLE);
                }
            }

            
        }

        supDB.exportDB();
        

        System.out.println("=================================================================================");
        System.out.printf("Successfully Registered for Project [%d] %s\n", currentProj.getProjectID(), currentProj.getProjectTitle());
        System.out.println("=================================================================================");

    }
}
