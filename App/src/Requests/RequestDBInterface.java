package Requests;

public interface RequestDBInterface {
    abstract void initializeFiles();
    abstract void updateDB(RequestType type);
    abstract void exportDB();
}
