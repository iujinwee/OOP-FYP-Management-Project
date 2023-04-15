package Controller.Project.GenerateProjectReportController;

import Boundaries.Menu.FooterInterface;
import Boundaries.Menu.HeaderInterface;
import Boundaries.Menu.UserBodyInterface;
import Controller.Project.LoadProjectDBController;

public abstract class GenerateReportController extends LoadProjectDBController implements HeaderInterface, UserBodyInterface, FooterInterface{

    public GenerateReportController(){
        super();
    }

    @Override
    public void footer() {
        if(projDB.objectDB.size()!=0){
			System.out.println("=======     NO PROJECTS FOUND!     =======");
		}else{
			System.out.println("\n=========   END OF PROJECT REPORT  ===========\n");
		}
    }
}
