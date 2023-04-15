package Controller.User.ModifyUsersDBController;

import java.util.Scanner;

import Entity.UserClass.Student;

public class CreateNewStudent extends ModifyUsersDBController {

    private String userID;
    private String name;
    private String email;
    private Student newStu;

    public CreateNewStudent(String userID) {
        super();
        this.userID = userID.toUpperCase();
        this.email = userID + "@e.ntu.edu.sg";
        updateDB();
        exportDB();
    }

    @Override
    public void updateDB() {
        Scanner sc = new Scanner(System.in);

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
