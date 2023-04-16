package Controller.Account.ModifyAccountDB;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.Classes.WelcomePage;
import Boundaries.Menu.Interfaces.GetInputInterface;
import Boundaries.Menu.Interfaces.ViewUserMenuInterface;
import Controller.User.ModifyUsersDB.*;
import Entity.AccountClass.Account;
import Exceptions.InvalidInputException;
import Exceptions.handleInvalidInput;

public class CreateNewAccount extends ModifyAccountDB implements ViewUserMenuInterface, GetInputInterface {

    private String userID;
    private Account newAcc;
    private handleInvalidInput handler = new handleInvalidInput(3);
    public Scanner sc = new Scanner(System.in);

    public CreateNewAccount() {
        super();
        updateDB();
        new WelcomePage();
    }

    @Override
    public void updateDB() {

        System.out.printf("\nEnter User ID: ");
        userID = sc.nextLine();
        if(!checkUserID(userID)) {
            viewUserMenu();
            while(handler.checkAttempts()) {
                try {
                    getInput();
                    System.out.println("======= Account Successfully Created! =======\n");
                    accDB.objectDB.add(newAcc);
                    exportDB();
                    break;

                } catch(InputMismatchException e) {
                    handler.handleInputMismatchException(e);
                    sc.nextLine();
                } catch(InvalidInputException e) {
                    handler.handleInvalidInputException(e);
                }
            }
        } else {            
            System.out.println("\nUser ID already exists!\n");
        }
    }

    @Override
    public void viewUserMenu() {
        System.out.println("\nSelect a User Type");
        System.out.println("=====================");
		System.out.println("[1] STUDENT");
		System.out.println("[2] SUPERVISOR");
        System.out.println("[3] FYP COORDINATOR");
    }

    @Override
    public void getInput() throws InvalidInputException {        
        System.out.printf("\nEnter option: ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                newAcc = new Account(userID, "STUDENT");
                new CreateNewStudent(newAcc.getUserID());
                break;

            case 2:
                newAcc = new Account(userID, "SUPERVISOR");
                new CreateNewSupervisor(newAcc.getUserID());
                break;
            
            case 3:
                newAcc = new Account(userID, "FYPCOORDINATOR");
                new CreateNewFYP_Coordinator(newAcc.getUserID());
                break;

            default:
                throw new InvalidInputException(choice);
        }
    }

    private boolean checkUserID(String inputUserID) {
        Account temp = accDB.findInstance(inputUserID);
        if(temp.getUserID() != null) {
            return true;
        } else {
            return false;
        }
    }
}
