package Controller.Project;

import Boundaries.Database.LoadFilesInterface;
import Entity.DatabaseClass.ProjectDB;

public class LoadProjectDBController implements LoadFilesInterface{
    public ProjectDB projDB; 

    public LoadProjectDBController(){
        loadFiles();
    }

    @Override
    public void loadFiles() {
        projDB = new ProjectDB();
    }
}
