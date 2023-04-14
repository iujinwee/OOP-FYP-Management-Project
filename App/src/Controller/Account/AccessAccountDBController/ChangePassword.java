package Controller.Account.AccessAccountDBController;

public class ChangePassword extends AccessAccountDBController {

    private String newPassword;

    public ChangePassword(String newPassword) {
        this.newPassword = newPassword;
        loadFiles();
        updateDB();
        exportDB();
    }

    @Override
    public void updateDB() {
        
    }
    
}
