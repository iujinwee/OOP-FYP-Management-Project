package Login;
public class Account {

    private String userID; 
    private String password;
    private userType userType;
    enum userType {STUDENT, SUPERVISOR, FYPCOORDINATOR}

    public Account(String userID, String password){
        this.userID = userID;
        this.password = password;
    }

    public boolean authenticate(Account[] accountList, String inputPassword){
        
        // iterate through accountlist to find account 
        return true;
    }


    public boolean changePassword(Account[] accountList){

        // update password if valid in the accountlist
        return true;
    }

    public void initializeUser(){
        switch (this.userType) {
            case STUDENT:
                User currentUser = new Student();
                break;
            
            case SUPERVISOR: 
                // User currentUser = Supervisor(userId);
            default:
                break;
        }

        currentUser.showMenu();
    }

    public String getUserID(){
        return this.userID;
    }

    public String getPassword(){
        return this.password;
    }

    public userType getUserType(){
        return this.userType;
    }
}
