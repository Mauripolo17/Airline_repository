package com.airline.airline.exceptions;

import lombok.Data;

@Data
public class ExistingUsernameException extends Exception {
    public ExistingUsernameException(String message) {
        super(message);
    }

    public ExistingUsernameException() {
    }
}
