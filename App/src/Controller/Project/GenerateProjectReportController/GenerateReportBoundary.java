package Controller.Project.GenerateProjectReportController;

import Boundaries.Menu.BodyInterface;
import Boundaries.Menu.FooterInterface;
import Boundaries.Menu.HeaderInterface;
import Controller.Project.LoadProjectDBController;

public abstract class GenerateReportBoundary extends LoadProjectDBController implements HeaderInterface, BodyInterface, FooterInterface {

    public GenerateReportBoundary() {
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
