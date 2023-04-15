package Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import Boundaries.Menu.FooterInterface;
import Boundaries.Menu.GetInputInterface;
import Boundaries.Menu.HeaderInterface;
import Boundaries.Menu.ViewUserMenuInterface;
import Controller.Account.Login;
import Controller.Account.ModifyAccountDBController.CreateNewAccount;
import Exceptions.handleInvalidInput;
import Exceptions.InvalidInputException;

public class WelcomePage implements HeaderInterface, ViewUserMenuInterface, GetInputInterface, FooterInterface {
    
    private handleInvalidInput handler = new handleInvalidInput(3);
    public Scanner sc = new Scanner(System.in);

    public WelcomePage(){

        header();

        while(handler.checkAttempts()) {
            try {    
                getInput();
                break;
            }catch(InputMismatchException e){
                handler.handleInputMismatchException(e);
                sc.nextLine();
            }catch(InvalidInputException e){
                handler.handleInvalidInputException(e);
            }
        } 
        
        footer();
    }
    
    @Override
    public void header() {
        System.out.println("*******************************************************************************************************");
        System.out.println("**                                                                                                   **");
        System.out.println("**   █▀▀▀ ░█──░█ ░█▀▀█    ░█▀▄▀█ █▀▀█ █▀▀▄ █▀▀█ █▀▀▀ █▀▀ █▀▄▀█ █▀▀ █▀▀▄ ▀▀█▀▀    ─█▀▀█ ░█▀▀█ ░█▀▀█   **");
        System.out.println("**   █▀▀▀ ░█▄▄▄█ ░█▄▄█    ░█░█░█ █▄▄█ █──█ █▄▄█ █─▀█ █▀▀ █─▀─█ █▀▀ █──█ ──█──    ░█▄▄█ ░█▄▄█ ░█▄▄█   **");
        System.out.println("**   █─── ──░█── ░█───    ░█──░█ ▀──▀ ▀──▀ ▀──▀ ▀▀▀▀ ▀▀▀ ▀───▀ ▀▀▀ ▀──▀ ──▀──    ░█─░█ ░█─── ░█───   **");
        System.out.println("**                                                                                                   **");    
        System.out.println("*******************************************************************************************************");
    }

    @Override
    public void footer() {
        System.out.println("\nExiting Program...\n");
    }

    @Override
    public void viewUserMenu() {
		System.out.println("Welcome");
        System.out.println("=======================");
		System.out.println("[1] Login");
		System.out.println("[2] Create New Account");
        System.out.println("[0] Exit Program");
    }

    @Override
    public void getInput() throws InvalidInputException {
        viewUserMenu();

        System.out.printf("\nEnter Option: ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                new Login();
                break;

            case 2:
                new CreateNewAccount();
                break;

            case 0:
                break;

            default:
                throw new InvalidInputException(choice); 
        }
    }
}
