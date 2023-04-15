package Boundaries.Menu.Classes;

import java.util.Scanner;

import Controller.Account.Login;
import Controller.Account.ModifyAccountDBController.CreateNewAccount;
import Controller.Menu.WelcomePageController;
import Exceptions.InvalidInputException;

public class WelcomePage extends WelcomePageController {
    
    public Scanner sc = new Scanner(System.in);

    public WelcomePage(){
        header(); 
        handleException();
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
