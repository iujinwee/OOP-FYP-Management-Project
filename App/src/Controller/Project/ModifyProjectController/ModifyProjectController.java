package Controller.Project.ModifyProjectController;

import Boundaries.Database.ExportDBInterface;
import Boundaries.Database.LoadFilesInterface;
import Boundaries.Database.UpdateDBInterface;
import Entity.DatabaseClass.ProjectDB;

public abstract class ModifyProjectController implements LoadFilesInterface, UpdateDBInterface, ExportDBInterface{

    public boolean filesInitialized = false; 
    public ProjectDB projDB;

    @Override
    public void loadFiles() {
        System.out.println("\nInitializing ProjectDB...");
        projDB = new ProjectDB();
        System.out.println("ProjectDB Initialized.\n");
    }

    @Override
    public void exportDB() {
        projDB.exportDB();
    }
}
