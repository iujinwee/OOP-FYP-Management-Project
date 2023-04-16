package Controller.Account.ModifyAccountDB;

import Controller.Account.LoadAccountDB;
import Controller.Interfaces.ExportDBInterface;
import Controller.Interfaces.UpdateDBInterface;

public abstract class ModifyAccountDB extends LoadAccountDB implements ExportDBInterface, UpdateDBInterface {
    
    /** 
     * Modify Account Database Constructor.
     */
    public ModifyAccountDB() {
        super();
    }
    
    @Override
    public void exportDB() {
        accDB.exportDB();
    }
}
