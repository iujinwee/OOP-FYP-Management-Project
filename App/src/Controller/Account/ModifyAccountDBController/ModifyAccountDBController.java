package Controller.Account.ModifyAccountDBController;

import Boundaries.Database.ExportDBInterface;
import Boundaries.Database.UpdateDBInterface;
import Controller.Account.LoadAccountDBController;

public abstract class ModifyAccountDBController extends LoadAccountDBController implements ExportDBInterface, UpdateDBInterface {
    
    public ModifyAccountDBController() {
        super();
    }
    
    @Override
    public void exportDB() {
        accDB.exportDB();
    }
}
