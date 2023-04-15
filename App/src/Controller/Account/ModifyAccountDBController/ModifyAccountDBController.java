package Controller.Account.ModifyAccountDBController;

import Controller.Account.LoadAccountDBController;
import Controller.Database.ExportDBInterface;
import Controller.Database.UpdateDBInterface;

public abstract class ModifyAccountDBController extends LoadAccountDBController implements ExportDBInterface, UpdateDBInterface {
    
    public ModifyAccountDBController() {
        super();
    }
    
    @Override
    public void exportDB() {
        accDB.exportDB();
    }
}
