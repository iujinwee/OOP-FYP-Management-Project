package Controller.Request;

import Boundaries.Database.LoadFilesInterface;
import Entity.DatabaseClass.RequestDB;

public abstract class LoadRequestDBController implements LoadFilesInterface {
    public RequestDB reqDB;

    public LoadRequestDBController(){
        loadFiles();
    }
    
    @Override
    public void loadFiles() {
        reqDB = new RequestDB();
    }
    
}
