package Controller.Account.AccessAccountDBController;

import Boundaries.Database.ExportDBInterface;
import Boundaries.Database.UpdateDBInterface;
import Controller.Account.LoadAccountDBController;

public abstract class AccessAccountDBController extends LoadAccountDBController implements UpdateDBInterface, ExportDBInterface{
    
    @Override
    public void exportDB() {
        accDB.exportDB();
    }

}
