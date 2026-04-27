package com.calculator.silva.exceptions;;

/* This exception is checked, the system will throw an exception if the user
input an invalid number to use for operations*/
public class InvalidInputException extends Exception {

    // Constructor without message
    public InvalidInputException () {
        super();
    }
    // Constructor with message
    public InvalidInputException (String message){
        super (message);
    }
}