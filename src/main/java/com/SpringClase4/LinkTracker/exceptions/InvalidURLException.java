package com.SpringClase4.LinkTracker.exceptions;

public class InvalidURLException extends Throwable {
    public InvalidURLException(){
        super("The url is incorrectly formatted");
    }
}
