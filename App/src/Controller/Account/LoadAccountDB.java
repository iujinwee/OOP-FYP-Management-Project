package Controller.Account;

import Controller.Interfaces.LoadFilesInterface;
import Entity.DatabaseClass.AccountDB;

public class LoadAccountDB implements LoadFilesInterface {

    public AccountDB accDB;

    public LoadAccountDB() {
        loadFiles();
    }

    @Override
    public void loadFiles() {
        accDB = new AccountDB();
    }
}
