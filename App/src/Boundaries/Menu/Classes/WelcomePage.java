package Boundaries.Menu.Classes;


import Boundaries.Menu.Interfaces.FooterInterface;
import Boundaries.Menu.Interfaces.HeaderInterface;
import Controller.Account.Login;
import Controller.Account.ModifyAccountDB.CreateNewAccount;
import Controller.Menu.CheckInputWelcomePage;
import Exceptions.InvalidInputException;

public class WelcomePage extends CheckInputWelcomePage implements HeaderInterface, FooterInterface {


    /**
     * Welcome Page Constructor.
     */
    public WelcomePage() {
        header();
        handleException();
        footer();
    }

    @Override
    public void header() {
        System.out.println(
                "*******************************************************************************************************");
        System.out.println(
                "**                                                                                                   **");
        System.out.println(
                "**   █▀▀▀ ░█──░█ ░█▀▀█    ░█▀▄▀█ █▀▀█ █▀▀▄ █▀▀█ █▀▀▀ █▀▀ █▀▄▀█ █▀▀ █▀▀▄ ▀▀█▀▀    ─█▀▀█ ░█▀▀█ ░█▀▀█   **");
        System.out.println(
                "**   █▀▀▀ ░█▄▄▄█ ░█▄▄█    ░█░█░█ █▄▄█ █──█ █▄▄█ █─▀█ █▀▀ █─▀─█ █▀▀ █──█ ──█──    ░█▄▄█ ░█▄▄█ ░█▄▄█   **");
        System.out.println(
                "**   █─── ──░█── ░█───    ░█──░█ ▀──▀ ▀──▀ ▀──▀ ▀▀▀▀ ▀▀▀ ▀───▀ ▀▀▀ ▀──▀ ──▀──    ░█─░█ ░█─── ░█───   **");
        System.out.println(
                "**                                                                                                   **");
        System.out.println(
                "*******************************************************************************************************");
    }

    @Override
    public void footer() {
        System.out.println("\nTerminating Program...\n");
    }

    @Override
    public void viewUserMenu() {
        System.out.println("Welcome");
        System.out.println("=======================");
        System.out.println("[1] Login");
        System.out.println("[2] Create New Account");
        System.out.println("[0] Exit Program");
    }

    /** 
	 * @throws InvalidInputException
	 */
    @Override
    public void getInput() throws InvalidInputException {
        
        int choice = -1;
        while (choice != 1 && choice != 2 && choice != 0) {
            viewUserMenu();

            System.out.printf("\nEnter Option: ");
            choice = sc.nextInt();

            switch (choice){
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
}
