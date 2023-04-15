package Controller.User.ModifyUsersDB;

import Controller.Interfaces.ExportDBInterface;
import Controller.Interfaces.UpdateDBInterface;
import Controller.User.LoadUsersDB;

public abstract class ModifyUsersDB extends LoadUsersDB implements UpdateDBInterface, ExportDBInterface {

    public ModifyUsersDB() {
        super();
    }

    @Override
    public void exportDB() {
        stuDB.exportDB();
        supDB.exportDB();
        fyp_coordDB.exportDB();
    }
    
}
