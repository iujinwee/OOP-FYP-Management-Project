package Controller.User.ModifyUsersDB;

import java.util.Scanner;

import Entity.UserClass.FYP_Coordinator;

public class CreateNewFYP_Coordinator extends ModifyUsersDB {

    private String userID;
    private String name;
    private String email;
    private FYP_Coordinator newFYP_Coord;
    public Scanner sc = new Scanner(System.in);

    public CreateNewFYP_Coordinator(String userID) {
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
        newFYP_Coord = new FYP_Coordinator(userID, name, email);
        fyp_coordDB.objectDB.add(newFYP_Coord);
    }
    
    @Override
    public void exportDB() {
        fyp_coordDB.exportDB();
    }
}
