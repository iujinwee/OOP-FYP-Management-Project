package Database;

public interface DatabaseInterface {
    abstract void initializeFiles();
    abstract void updateDB();
    abstract void exportDB();
}
