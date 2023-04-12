package Requests.enactRequestsPackage;

import java.util.Scanner;

import Database.ProjectDB;
import Requests.ModifyRequestDB;
import Requests.Request;
import Requests.RequestType;

public abstract class EnactRequest extends ModifyRequestDB implements EnactRequestInterface{
    
    public ProjectDB projDB;
    public Request request;

    public EnactRequest(int reqID){
        initializeFiles();
        this.request = reqDB.findInstance(reqID);
        updateDB(request.getRequestType());
        exportDB();
    }

    @Override
    public void initializeFiles() {
        super.initializeFiles();
        System.out.println("\nInitializing ProjectDB...");
        projDB = new ProjectDB();
        System.out.println("ProjectDB Initialized.\n");
    }

    @Override
    public void updateDB(RequestType type) {

        System.out.println("\n> Approve/ Reject");
        System.out.println("[1] Approve");
        System.out.println("[0] Reject");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        enactRequest(choice);
        sc.close();
    }
}
