package Users;
public class Student extends User{
    
    private String studentID;
    private userType userType;
    // private RequestList requestDB;

    public Student(String userID, String name, String email){
        super(userID, name, email);
        this.studentID = userID;
        this.userType = Users.User.userType.STUDENT;

        showUserMenu();
    }

    @Override
    public void showUserMenu() {
        System.out.println("=== User Menu ===");
        System.out.println("[1] View Available Projects");
        System.out.println("[2] View Registered Project");
        System.out.println("[3] Register Project");
        System.out.println("[4] Deregister Project");
        System.out.println("[5] Request to change project title");

        System.out.println("\nSelect an option from the menu: ");
    }

    @Override
    public userType getUserType() {
        return this.userType;
    }

    // private createRequest(){
    //     requestDB.createRequest(requestType); // changetitle, registers, deregister
    // }

    // public viewProjects(){
        
    // }
    // public showMenu(){
    //     PRINT STATEMENTS
    //     // [1] create req

    //     // [2] show avail projects 
    //     // [3] show registered projects

    //     ASK FOR INPUT 

    // switch(CHOICE){
    //     case 1:
    //         requestDB.viewProjects(userType)
    //     case 2:
    // }      
    
}

