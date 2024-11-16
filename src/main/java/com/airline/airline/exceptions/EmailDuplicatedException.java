package com.airline.airline.exceptions;

import lombok.Data;

@Data
public class EmailDuplicatedException extends Exception {
    public EmailDuplicatedException() {
    }

    public EmailDuplicatedException(String message) {
        super(message);
    }

    public EmailDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
