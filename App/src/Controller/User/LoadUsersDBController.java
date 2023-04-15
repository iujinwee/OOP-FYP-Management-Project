package Controller.User;

import Boundaries.Database.LoadFilesInterface;
import Entity.DatabaseClass.StudentDB;
import Entity.DatabaseClass.SupervisorDB;
import Entity.DatabaseClass.FYP_CoordinatorDB;

public class LoadUsersDBController implements LoadFilesInterface{

    public StudentDB stuDB;
    public SupervisorDB supDB;
    public FYP_CoordinatorDB fypcoordDB;

    @Override
    public void loadFiles() {
        System.out.println("\nInitializing StudentDB, SupervisorDB, FYP_CoordinatorDB...");
        stuDB = new StudentDB();
        supDB = new SupervisorDB();
        fypcoordDB = new FYP_CoordinatorDB();
        System.out.println("StudentDB, SupervisorDB, FYP_CoordinatorDB Initialized.\n");
    }
}
