// Base Class (Super)
public class User implements UserInterface{

    private String userId;
    private String email;
    
    public User(String userId, String email, String userType){
        this.userId = userId;
        this.email = email;
    }

    @Override
    public void viewProjects() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewRequestHistory() {
        // TODO Auto-generated method stub
        
    }

    public String getUserId(){
        return this.userId;
    }

}
