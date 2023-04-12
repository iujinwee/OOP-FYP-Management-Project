package Requests;

import Database.RequestDB;

public abstract class NewRequest implements RequestDBInterface{

    public boolean filesInitialized = false; 
    public RequestDB reqDB;

    @Override
    public void initializeFiles() {
        System.out.println("\nInitializing RequestDB...");
        reqDB = new RequestDB();
        System.out.println("RequestDB Initialized.\n");
    }

    @Override
    public void exportDB() {
        reqDB.exportDB();
    }
}
