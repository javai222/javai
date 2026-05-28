package com.calculator.plantilla.exception;

/* This is exception is unchecked, wherein the system will throw an exception
if the user input negative numbers with the operators*/ 
public class NegativeNumbersException extends RuntimeException {
    public NegativeNumbersException (String message){
        super (message);
    }
}