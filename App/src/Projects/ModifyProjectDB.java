package Projects;

import Database.ProjectDB;

public abstract class ModifyProjectDB implements ProjectDBInterface{

    public boolean filesInitialized = false; 
    public ProjectDB projDB;

    @Override
    public void initializeFiles() {
        System.out.println("\nInitializing ProjectDB...");
        projDB = new ProjectDB();
        System.out.println("ProjectDB Initialized.\n");
    }

    @Override
    public void exportDB() {
        projDB.exportDB();
    }
}
