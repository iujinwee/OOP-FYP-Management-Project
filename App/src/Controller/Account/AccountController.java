package Controller.Account;

import Boundaries.Database.ExportDBInterface;
import Boundaries.Database.LoadFilesInterface;
import Boundaries.Database.UpdateDBInterface;
import Entity.DatabaseClass.AccountDB;

public abstract class AccountController implements LoadFilesInterface, UpdateDBInterface, ExportDBInterface{

    public boolean filesInitialized = false; 
    public AccountDB accDB;

    @Override
    public void loadFiles() {
        System.out.println("\nInitializing AccountDB...");
        accDB = new AccountDB();
        System.out.println("AccountDB Initialized.\n");
    }

    @Override
    public void exportDB() {
        accDB.exportDB();
    }
}