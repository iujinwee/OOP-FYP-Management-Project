package Controller.Project.GenerateProjectReportController;

import Boundaries.Database.LoadFilesInterface;
import Boundaries.Project.ViewProjectListInterface;
import Entity.DatabaseClass.ProjectDB;

public abstract class GenerateReportController implements ViewProjectListInterface, LoadFilesInterface{

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
