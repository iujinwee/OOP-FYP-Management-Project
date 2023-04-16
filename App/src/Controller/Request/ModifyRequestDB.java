package Controller.Request;

import Controller.Interfaces.ExportDBInterface;
import Controller.Interfaces.UpdateDBInterface;

public abstract class ModifyRequestDB extends LoadRequestDB implements UpdateDBInterface, ExportDBInterface{

    /** 
     * Modify Request Database Constructor.
     */
    public ModifyRequestDB(){
        super();
    }
    @Override
    public void exportDB() {
        reqDB.exportDB();
    }
}
