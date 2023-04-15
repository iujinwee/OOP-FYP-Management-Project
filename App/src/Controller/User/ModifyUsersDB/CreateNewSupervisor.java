package Controller.User.ModifyUsersDB;

import java.util.Scanner;

import Entity.UserClass.Supervisor;

public class CreateNewSupervisor extends ModifyUsersDB {

    private String userID;
    private String name;
    private String email;
    private Supervisor newSup;
    public Scanner sc = new Scanner(System.in);

    public CreateNewSupervisor(String userID) {
        super();
        this.userID = userID;
        this.email = userID + "@NTU.EDU.SG";
        updateDB();
        exportDB();
    }

    @Override
    public void updateDB() {
        System.out.printf("Enter Name: ");
        this.name = sc.nextLine();
        newSup = new Supervisor(userID, name, email, 0);
        supDB.objectDB.add(newSup);
    }
    
    @Override
    public void exportDB() {
        supDB.exportDB();
    }
}

