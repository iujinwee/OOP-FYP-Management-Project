package Controller.Project.ModifyProjectController;

import Boundaries.Database.ExportDBInterface;
import Boundaries.Database.UpdateDBInterface;
import Controller.Project.LoadProjectDBController;
import Entity.DatabaseClass.ProjectDB;

public abstract class ModifyProjectController extends LoadProjectDBController implements UpdateDBInterface, ExportDBInterface{

    public boolean filesInitialized = false; 
    public ProjectDB projDB;

    public ModifyProjectController(){
        super();
    }

    @Override
    public void exportDB() {
        projDB.exportDB();
    }
}
