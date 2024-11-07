package com.airline.airline.exceptions;


public class ClienteNotFoundException extends ResourceNotFoundException {

    public ClienteNotFoundException() {
        this("Cliente no encontrado");
    }

    public ClienteNotFoundException(String message) {
        super(message);
    }

    public ClienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
