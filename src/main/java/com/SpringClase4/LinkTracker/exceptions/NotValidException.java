package com.SpringClase4.LinkTracker.exceptions;

public class NotValidException extends Exception{
    public NotValidException(){
        super("The link is not valid.");
    }
}
