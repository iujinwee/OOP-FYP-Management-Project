package Exceptions;

public class InvalidInputException extends Exception{
    
    public InvalidInputException(){
        super("Invalid Input Exception");
    }

    public InvalidInputException(int choice){
        super(choice + " is an invalid option!");
    }

    public InvalidInputException(String input){
        super(input + " is an invalid input!");
    }

    public InvalidInputException(Exception e){
        super(e.getMessage());
    }
}
