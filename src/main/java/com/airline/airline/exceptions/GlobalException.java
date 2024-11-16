package com.airline.airline.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundHandler(ResourceNotFoundException ex, WebRequest wr){
        ErrorMessage error = new ErrorMessage();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(value = EmailDuplicatedException.class)
    public ResponseEntity<ErrorMessage> emailDuplicatedHandler(EmailDuplicatedException ex, WebRequest wr){
        ErrorMessage error = new ErrorMessage();
        error.setStatus(HttpStatus.CONFLICT.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }


    @ExceptionHandler(value = ExistingUsernameException.class)
    public ResponseEntity<ErrorMessage> existingUsernameHandler(ExistingUsernameException ex, WebRequest wr){
        ErrorMessage error = new ErrorMessage();
        error.setStatus(HttpStatus.CONFLICT.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }


    @ExceptionHandler(value= IDNumberDuplicatedException.class)
    public ResponseEntity<ErrorMessage> idNumberDuplicatedHandler(IDNumberDuplicatedException ex, WebRequest wr){
        ErrorMessage error = new ErrorMessage();
        error.setStatus(HttpStatus.CONFLICT.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

}
