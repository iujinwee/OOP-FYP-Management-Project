package Controller.Request.EnactRequestController;

import java.util.Scanner;

import Boundaries.Request.EnactRequestInterface;
import Controller.Request.ModifyRequestController;
import Entity.DatabaseClass.ProjectDB;
import Entity.RequestClass.Request;

public abstract class EnactRequestController extends ModifyRequestController implements EnactRequestInterface{
    
    public ProjectDB projDB;
    public Request request;

    public EnactRequestController(int reqID){
        loadFiles();
        this.request = reqDB.findInstance(reqID);
        updateDB();
        exportDB();
    }

    @Override
    public void loadFiles() {
        super.loadFiles();
        System.out.println("\nInitializing ProjectDB...");
        projDB = new ProjectDB();
        System.out.println("ProjectDB Initialized.\n");
    }

    @Override
    public void updateDB() {

        System.out.println("\n> Approve/ Reject");
        System.out.println("[1] Approve");
        System.out.println("[0] Reject");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        enactRequest(choice);
        sc.close();
    }
}
