package com.airline.airline.exceptions;

public class ClienteNotFoundException extends ResourceNotFoundException {

    public ClienteNotFoundException(String message) {
        super(message);
    }
}
