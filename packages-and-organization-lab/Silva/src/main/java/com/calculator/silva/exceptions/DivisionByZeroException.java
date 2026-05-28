package com.calculator.silva.exceptions;

/* This exception is unchecked, wherein it shows that the system will throw an
exception if the user divide anumber by zero*/
public class DivisionByZeroException extends RuntimeException {
    public DivisionByZeroException (String message){
        super(message);
    }
}