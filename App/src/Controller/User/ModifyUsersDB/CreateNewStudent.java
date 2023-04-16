package Controller.User.ModifyUsersDB;

import java.util.Scanner;

import Entity.UserClass.Student;

public class CreateNewStudent extends ModifyUsersDB {

    private String userID;
    private String name;
    private String email;
    private Student newStu;
    public Scanner sc = new Scanner(System.in);

    /** 
     * Create New Student Constructor.
     * @param userID Unique ID of User
     */
    public CreateNewStudent(String userID) {
        super();
        this.userID = userID.toUpperCase();
        this.email = userID + "@e.ntu.edu.sg";
        updateDB();
        exportDB();
    }

    @Override
    public void updateDB() {
        System.out.printf("Enter Name: ");
        this.name = sc.nextLine().toUpperCase();
        newStu = new Student(userID, name, email, false);
        stuDB.objectDB.add(newStu);
    }
    
    @Override
    public void exportDB() {
        stuDB.exportDB();
    }
}
