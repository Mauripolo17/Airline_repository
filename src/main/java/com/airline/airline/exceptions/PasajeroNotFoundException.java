package com.airline.airline.exceptions;


public class PasajeroNotFoundException extends ResourceNotFoundException {

    public PasajeroNotFoundException() {
        this("Pasajero no encontrado");
    }

    public PasajeroNotFoundException(String message) {
        super(message);
    }

    public PasajeroNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
