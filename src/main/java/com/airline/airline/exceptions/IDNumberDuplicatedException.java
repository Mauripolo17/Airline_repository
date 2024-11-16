package com.airline.airline.exceptions;

public class IDNumberDuplicatedException extends Exception{
    public IDNumberDuplicatedException() {
    }

    public IDNumberDuplicatedException(String message) {
        super(message);
    }

    public IDNumberDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
