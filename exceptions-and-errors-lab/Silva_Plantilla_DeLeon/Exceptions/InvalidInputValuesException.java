package Exceptions;

/* This exception is checked, the system will throw an exception if the user
input an invalid number to use for operations*/
public class InvalidInputValuesException extends Exception {

    // Constructor without message
    public InvalidInputValuesException () {
        super();
    }
    // Constructor with message
    public InvalidInputValuesException (String message){
        super (message);
    }
}