package Exceptions;

import java.util.Scanner;

public class handleInvalidInput {
    
    private Scanner sc;
    private int attempts = 0; 
    private final static int MAX_ATTEMPTS = 3;

    public handleInvalidInput(Scanner scanner){
        this.sc = scanner;
    }
	public void handleInputMismatchException(Exception e){
		System.out.println("\nInvalid Input. Please enter a number.");
		sc.nextLine();
		System.out.printf("Remaining Attempts left: %d\n\n", MAX_ATTEMPTS - ++attempts);
	}	

	public void handleInvalidInputException(Exception e){
		System.out.printf("\nInvalid Input. %s\n", e.getMessage());
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
