package com.SpringClase4.LinkTracker.exceptions;

public class IncorrectPasswordException extends Exception{
    public IncorrectPasswordException(){
        super("The password is incorrect.");
    }
}
