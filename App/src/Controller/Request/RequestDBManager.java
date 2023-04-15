package Controller.Request;

import Controller.Database.ExportDBInterface;
import Controller.Database.UpdateDBInterface;

public abstract class RequestDBManager extends LoadRequestDBController implements UpdateDBInterface, ExportDBInterface{

    public RequestDBManager(){
        super();
    }
    @Override
    public void exportDB() {
        reqDB.exportDB();
    }
}
