package Exceptions;

import java.util.InputMismatchException;

public class handleInvalidInput {
    
    private int attempts = 0; 
    private int MAX_ATTEMPTS = 0;

    public handleInvalidInput(){}

    public handleInvalidInput(int attempts){
        this.MAX_ATTEMPTS = attempts;
    }

	public void handleInputMismatchException(InputMismatchException e){
        System.out.println("\nERROR!");
		System.out.println("Invalid Input. Please enter a number.\n");
        if(MAX_ATTEMPTS!=0){
            System.out.printf("Remaining Attempts left: %d\n\n", MAX_ATTEMPTS - ++attempts);
        }
	}	

	public void handleInvalidInputException(InvalidInputException e){
        System.out.println("\nERROR!");
		System.out.println("Invalid Input. Please select one of the following options.\n");
        if(MAX_ATTEMPTS!=0){
            System.out.printf("Remaining Attempts left: %d\n\n", MAX_ATTEMPTS - ++attempts);
        }
	}	

    public boolean checkAttempts(){
        if(attempts==MAX_ATTEMPTS){
            System.out.println("Out of Attempts. Please try again later...\n");
            return false;
        }
        return true;
    }
}
