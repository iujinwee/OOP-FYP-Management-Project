package Controller.Request;

import Controller.Interfaces.LoadFilesInterface;
import Entity.DatabaseClass.RequestDB;

public abstract class LoadRequestDB implements LoadFilesInterface {
    public RequestDB reqDB;

    /** 
     * Load Request Database Constructor.
     */
    public LoadRequestDB(){
        loadFiles();
    }
    
    @Override
    public void loadFiles() {
        reqDB = new RequestDB();
    }
    
}
