package com.airline.airline.exceptions;


public class AerolineaNotFoundException extends ResourceNotFoundException {

    public AerolineaNotFoundException(){
        this("Aerolinea no encontrada");
    }

    public AerolineaNotFoundException(String message) {
        super(message);
    }

    public AerolineaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
