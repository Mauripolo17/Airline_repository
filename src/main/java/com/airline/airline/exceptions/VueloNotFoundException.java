package com.airline.airline.exceptions;




public class VueloNotFoundException extends ResourceNotFoundException {

    public VueloNotFoundException(){
        this("Vuelo no encontrado");
    }

    public VueloNotFoundException(String message) {
        super(message);
    }

    public VueloNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
