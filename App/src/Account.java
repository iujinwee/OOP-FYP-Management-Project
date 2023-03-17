public class Account {

    private String userId; 
    private String password;
    private userType userType;
    enum userType {STUDENT, SUPERVISOR, FYPCOORDINATOR}

    public Account(String userId, String password){
        this.userId = userId;
        this.password = password;
    }

    public boolean authenticate(Account[] accountList){
        
        // iterate through accountlist to find account 

        this.userType = "STUDENT";

        return true;
    }
    public boolean changePassword(Account[] accountList){

        // update password if valid in the accountlist
        return true;
    }

    public void initializeUser(){
        switch (this.userType) {
            case STUDENT:
                User currentUser = Student(userId, email, this.userType);
                
                break;
            
            case SUPERVISOR: 
                User currentUser = Supervisor(userId);
            default:
                break;
        }

        currentUser.showMenu();
    }

    public String getUserId(){
        return this.userId;
    }
}
