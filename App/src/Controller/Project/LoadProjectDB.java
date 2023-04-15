package Controller.Project;

import Controller.Interfaces.LoadFilesInterface;
import Entity.DatabaseClass.ProjectDB;

public class LoadProjectDB implements LoadFilesInterface {

    public ProjectDB projDB; 

    public LoadProjectDB() {
        loadFiles();
    }

    @Override
    public void loadFiles() {
        projDB = new ProjectDB();
    }
}
