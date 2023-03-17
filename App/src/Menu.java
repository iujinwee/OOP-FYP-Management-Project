public class Menu {
    
    public Menu(User user){
        switch(user.userType){
            case student:
                studentMenu();
            case supervisor: 
                supervisorMenu();
        }
    }
}
