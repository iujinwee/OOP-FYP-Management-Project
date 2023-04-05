package Users.ErrorHandler;

public class InvalidInputException extends Exception{
    
    public InvalidInputException(){
        super("Invalid Input Exception");
    }

    public InvalidInputException(int choice){
        super(choice + "is an invalid option!");
    }

    public InvalidInputException(String message){
        super(message);
    }
}
