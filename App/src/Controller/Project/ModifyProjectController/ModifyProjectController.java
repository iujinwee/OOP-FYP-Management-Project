package Controller.Project.ModifyProjectController;

import Controller.Database.ExportDBInterface;
import Controller.Database.UpdateDBInterface;
import Controller.Project.LoadProjectDBController;

public abstract class ModifyProjectController extends LoadProjectDBController implements UpdateDBInterface, ExportDBInterface {

    public ModifyProjectController() {
        super();
    }

    @Override
    public void exportDB() {
        projDB.exportDB();
    }
}
