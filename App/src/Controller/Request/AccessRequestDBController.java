package Controller.Request;

import Boundaries.Database.ExportDBInterface;
import Boundaries.Database.LoadFilesInterface;
import Boundaries.Database.UpdateDBInterface;
import Entity.DatabaseClass.RequestDB;

public abstract class AccessRequestDBController implements LoadFilesInterface, UpdateDBInterface, ExportDBInterface{

    public RequestDB reqDB;

    @Override
    public void loadFiles() {
        System.out.println("\nInitializing RequestDB...");
        reqDB = new RequestDB();
        System.out.println("RequestDB Initialized.\n");
    }

    @Override
    public void exportDB() {
        reqDB.exportDB();
    }
}
