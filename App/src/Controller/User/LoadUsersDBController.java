package Controller.User;

import Entity.DatabaseClass.StudentDB;
import Entity.DatabaseClass.SupervisorDB;
import Controller.Database.LoadFilesInterface;
import Entity.DatabaseClass.FYP_CoordinatorDB;

public class LoadUsersDBController implements LoadFilesInterface{

    public StudentDB stuDB;
    public SupervisorDB supDB;
    public FYP_CoordinatorDB fyp_coordDB;

    public LoadUsersDBController() {
        loadFiles();
    }

    @Override
    public void loadFiles() {
        stuDB = new StudentDB();
        supDB = new SupervisorDB();
        fyp_coordDB = new FYP_CoordinatorDB();
    }
}
