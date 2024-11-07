package com.airline.airline.exceptions;

import lombok.Data;

@Data
public class AeropuertoNotFoundException extends ResourceNotFoundException {

    public AeropuertoNotFoundException(){
        this("Aeropuerto no encontrado");
    }

    public AeropuertoNotFoundException(String message) {
        super(message);
    }

    public AeropuertoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
