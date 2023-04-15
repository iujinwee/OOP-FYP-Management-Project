package Controller.Project.GenerateProjectReportController;

import Boundaries.Menu.Interfaces.FooterInterface;
import Boundaries.Menu.Interfaces.HeaderInterface;
import Boundaries.Menu.Interfaces.UserBodyInterface;
import Controller.Project.LoadProjectDBController;

public abstract class GenerateReportController extends LoadProjectDBController implements HeaderInterface, UserBodyInterface, FooterInterface {

    public GenerateReportController() {
        super();
    }

    @Override
    public void footer() {
        if(projDB.objectDB.size()!=0) {
			System.out.println("=======     NO PROJECTS FOUND!     =======");
		} else {
			System.out.println("\n=========   END OF PROJECT REPORT  ===========\n");
		}
    }
}
