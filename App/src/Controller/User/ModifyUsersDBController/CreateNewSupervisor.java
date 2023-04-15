package Controller.User.ModifyUsersDBController;

import java.util.Scanner;

import Entity.UserClass.Supervisor;

public class CreateNewSupervisor extends ModifyUsersDBController {

    private String userID;
    private String name;
    private String email;
    private Supervisor newSup;

    public CreateNewSupervisor(String userID) {
        super();
        this.userID = userID;
        this.email = userID + "@NTU.EDU.SG";
        updateDB();
        exportDB();
    }

    @Override
    public void updateDB() {
        Scanner sc = new Scanner(System.in);

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

