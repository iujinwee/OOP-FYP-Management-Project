package Controller.Project.ModifyProjectController;

import Boundaries.Database.ExportDBInterface;
import Boundaries.Database.UpdateDBInterface;
import Boundaries.Menu.GetInputInterface;
import Controller.Project.LoadProjectDBController;

public abstract class ModifyProjectController extends LoadProjectDBController implements UpdateDBInterface, ExportDBInterface{

    public ModifyProjectController() {
        super();
    }

    @Override
    public void exportDB() {
        projDB.exportDB();
    }
}
