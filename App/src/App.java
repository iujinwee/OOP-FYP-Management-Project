import Database.ProjectDB;
import Database.RequestDB;
import Requests.RequestType;
import Users.Student;
import Users.Supervisor;

public class App {

	public static void main(String[] args) {
        RequestDB db = new RequestDB();
        db.createRequest(RequestType.CHANGESUPERVISOR, new Student("h", "h", "h"), new Supervisor("y", "y", "y"));
        db.createRequest(RequestType.CHANGETITLE, new Student("h", "h", "h"), new Supervisor("y", "y", "y"));
        db.exportDB();

        // Introduction to App 
        System.out.println("\n================================================================");
        System.out.println("======    Welcome to Final Year Project Management App    ======");
        System.out.println("================================================================\n");


        // Login (Login with 5 attempts, use try, catch to handle invalid  inputs. once 5 attempts up, terminate program)
        // int loginAttempts = 1;
        // boolean loginSuccess = login();
        // while(!loginSuccess && loginAttempts <= 5){
        //     login();
        //     loginAttempts++;
        // }

        // Show menu depending on user type
        
        // Execute choice of user
	}

	
    // private static boolean login(){
    //     String inputUserID;
    //     String inputPassword;
    //     Account account;
        
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter User ID: ");
    //     inputUserID = sc.nextLine();
    //     System.out.println("Enter Password: ");
    //     inputPassword = sc.nextLine();

    //     // if (account = AccountDB.findAcc()) {
    //         // account.authenticate(inputPassword);
    //         // return true;
    //     // } else {
    //         // print "invalid user id"
    //         // return false;
    //     // }
        
    // }
}