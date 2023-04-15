package Controller.Account;

import Controller.Database.LoadFilesInterface;
import Entity.DatabaseClass.AccountDB;

public class LoadAccountDBController implements LoadFilesInterface {

    public AccountDB accDB;

    public LoadAccountDBController() {
        loadFiles();
    }

    @Override
    public void loadFiles() {
        accDB = new AccountDB();
    }
}
