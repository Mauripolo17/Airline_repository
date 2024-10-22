package com.airline.airline.exceptions;

public class PasajeroNotFoundException extends ResourceNotFoundException {

    public PasajeroNotFoundException(String message) {
        super(message);
    }
}
