package Exceptions;

import java.util.Scanner;

public class handleInvalidInput {
    
    private Scanner sc;
    private int attempts = 0; 
    private int MAX_ATTEMPTS;

    public handleInvalidInput(Scanner scanner, int attempts){
        this.sc = scanner;
        this.MAX_ATTEMPTS = attempts;
    }
	public void handleInputMismatchException(Exception e){
        System.out.println("\nERROR!");
		System.out.println("Invalid Input. Please enter a number.");
		System.out.printf("Remaining Attempts left: %d\n\n", MAX_ATTEMPTS - ++attempts);
        sc.nextLine();
	}	

	public void handleInvalidInputException(Exception e){
        System.out.println("\nERROR!");
		System.out.printf("Invalid Input. %s\n", e.getMessage());
		System.out.printf("Remaining Attempts left: %d\n\n", MAX_ATTEMPTS - ++attempts);
	}	

    public boolean checkAttempts(){
        if(attempts==MAX_ATTEMPTS){
            System.out.println("Out of Attempts. Please try again later...\n");
            return false;
        }
        return true;
    }
}
