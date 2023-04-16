package Controller.User;

import Entity.DatabaseClass.StudentDB;
import Entity.DatabaseClass.SupervisorDB;
import Controller.Interfaces.LoadFilesInterface;
import Entity.DatabaseClass.FYP_CoordinatorDB;

public class LoadUsersDB implements LoadFilesInterface{

    public StudentDB stuDB;
    public SupervisorDB supDB;
    public FYP_CoordinatorDB fyp_coordDB;

    /** 
     * Load Users Database Constructor.
     */
    public LoadUsersDB() {
        loadFiles();
    }

    @Override
    public void loadFiles() {
        stuDB = new StudentDB();
        supDB = new SupervisorDB();
        fyp_coordDB = new FYP_CoordinatorDB();
    }
}
