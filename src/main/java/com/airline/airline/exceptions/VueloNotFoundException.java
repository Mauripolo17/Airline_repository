package com.airline.airline.exceptions;

public class VueloNotFoundException extends ResourceNotFoundException {

    public VueloNotFoundException(String message) {
        super(message);
    }
}
