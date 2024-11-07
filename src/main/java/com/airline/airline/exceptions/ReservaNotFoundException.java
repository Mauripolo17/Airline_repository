package com.airline.airline.exceptions;

public class ReservaNotFoundException extends ResourceNotFoundException {

    public ReservaNotFoundException(){
        this("Reserva no encontrada");
    }

    public ReservaNotFoundException(String message) {
        super(message);
    }

    public ReservaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
