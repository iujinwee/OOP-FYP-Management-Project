package Users;

import Users.User.userType;

public class Menu {
    public Menu(userType type){
        showMenu(type);
    }

    public void showMenu(userType type){

        System.out.println("=======================================");
        System.out.println("   Welcome to FYP Management System!   ");
        System.out.println("=======================================");
        System.out.printf("You are currently signed in as a %s.\n", type);

        switch(type){
            case STUDENT: 
                System.out.println("[1] View Projects");
                System.out.println("");
                break;

            case SUPERVISOR: 
                System.out.println("[1] ");

                break;

            case FYPCOORDINATOR:

                break;

            default: 
                break;
        }
    }
}
