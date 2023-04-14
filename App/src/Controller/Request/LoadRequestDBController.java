package Controller.Request;

import Boundaries.Database.LoadFilesInterface;
import Entity.DatabaseClass.RequestDB;

public class LoadRequestDBController implements LoadFilesInterface {
    public RequestDB reqDB;

    public LoadRequestDBController(){
        loadFiles();
    }
    
    @Override
    public void loadFiles() {
        reqDB = new RequestDB();
    }
    
}
