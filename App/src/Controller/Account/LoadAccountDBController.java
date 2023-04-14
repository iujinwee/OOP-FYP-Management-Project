package Controller.Account;

import Boundaries.Database.LoadFilesInterface;
import Entity.DatabaseClass.AccountDB;

public abstract class LoadAccountDBController implements LoadFilesInterface{

    public AccountDB accDB;

    @Override
    public void loadFiles() {
        System.out.println("\nInitializing AccountDB...");
        accDB = new AccountDB();
        System.out.println("AccountDB Initialized.\n");
    }
}
