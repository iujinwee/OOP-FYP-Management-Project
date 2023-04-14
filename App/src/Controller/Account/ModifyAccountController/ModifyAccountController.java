package Controller.Account.ModifyAccountController;

import Boundaries.Database.ExportDBInterface;
import Boundaries.Database.UpdateDBInterface;
import Controller.Account.LoadAccountDBController;

public abstract class ModifyAccountController extends LoadAccountDBController implements UpdateDBInterface, ExportDBInterface{
    
    @Override
    public void exportDB() {
        accDB.exportDB();
    }

}
