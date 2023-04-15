package Controller.User.ModifyUsersDBController;

import Boundaries.Database.ExportDBInterface;
import Boundaries.Database.UpdateDBInterface;
import Controller.User.LoadUsersDBController;

public abstract class ModifyUsersDBController extends LoadUsersDBController implements UpdateDBInterface, ExportDBInterface {

    public ModifyUsersDBController() {
        super();
    }

    @Override
    public void exportDB() {
        stuDB.exportDB();
        supDB.exportDB();
        fyp_coordDB.exportDB();
    }
    
}
