package Controller.Project.GenerateProjectReportController;

import Boundaries.Database.LoadFilesInterface;
import Boundaries.Menu.FooterInterface;
import Boundaries.Menu.HeaderInterface;
import Boundaries.Menu.UserBodyInterface;
import Entity.DatabaseClass.ProjectDB;

public abstract class GenerateReportController implements HeaderInterface, UserBodyInterface, FooterInterface, LoadFilesInterface{

    private ProjectDB projDB;

    @Override
    public void loadFiles() {
        System.out.println("\nInitializing ProjectDB...");
        projDB = new ProjectDB();
        System.out.println("ProjectDB Initialized.\n");
    }

    @Override
    public void footer() {
        System.out.println("============        END OF REPORT       ============");
    }
}
