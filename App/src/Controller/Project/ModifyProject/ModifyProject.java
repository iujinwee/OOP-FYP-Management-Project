package Controller.Project.ModifyProject;

import Controller.Interfaces.ExportDBInterface;
import Controller.Interfaces.UpdateDBInterface;
import Controller.Project.LoadProjectDB;

public abstract class ModifyProject extends LoadProjectDB implements UpdateDBInterface, ExportDBInterface {

    /** 
     * Modify Project Constructor.
     */
    public ModifyProject() {
        super();
    }

    @Override
    public void exportDB() {
        projDB.exportDB();
    }
}
