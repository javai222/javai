package Exceptions;

/* This is exception is unchecked, wherein the system will throw an exception
if the user input negative numbers with the operators*/ 
public class NegativeNumberException extends RuntimeException (
    public NegativeNumberException (String message){
        super (message);
    }
)