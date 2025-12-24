package com.a100.librarymanagement.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("Email already exists: " + email);
    }
}
