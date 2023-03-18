public class User{

    private String userID;
    private String name;
    private String email;
    
    public User(){
        
    }

    public User(String userID, String name, String email){
        this.userID = userID;
        this.name = name;
        this.email = email;
    }

    public String getUserID(){
        return this.userID;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    // @Override
    // public void viewProjects() {
        
    // }

    // @Override
    // public void viewRequestHistory() {
        
    // }
}
