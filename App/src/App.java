import java.util.Scanner;

public class App {

    private Account[] accountList;
    private User[] userList;
    private Coordinator[] coordinatorList;

    public static void main(String[] args) throws Exception {
        
        // File Initialization
        initalizeSystem();

        // Intro 

        // Login
        login();


    }

    // studentList 
    // supervisorList 


    private static void login(){
        Scanner sc = new Scanner(System.in);
        String userId; 
        String password;
        try{
            System.out.println("Enter User ID: ");
            userId = sc.nextLine();
            System.out.println("Enter Password: ");
            String password = sc.nextLine();
            throw new Exception(incorrectInput);
        }catch(Exception e){
            // exception handler
        }
        
        Account currentUserAccount = new Account(userId, password);

        if(currentUserAccount.authenticate(accountList)) {
            
            currentUserAccount.initializeUser();

        }else{
            // exception handling 
        }
    }

    private void initalizeSystem(){
        this.accountList = loadFile(new File, Account); // Account[]
        this.userList = loadFile(new File, User); // User[]
    }

    private List<Object> loadFile(File file, ObjectType){

        // read file
        file 

        return List<Object>;
    }
    
}
