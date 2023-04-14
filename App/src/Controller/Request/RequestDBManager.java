package Controller.Request;

import Boundaries.Database.ExportDBInterface;
import Boundaries.Database.UpdateDBInterface;

public abstract class RequestDBManager extends LoadRequestDBController implements UpdateDBInterface, ExportDBInterface{

    public RequestDBManager(){
        super();
    }
    @Override
    public void exportDB() {
        reqDB.exportDB();
    }
}
