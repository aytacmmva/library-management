package com.a100.librarymanagement.exception.alreadyexist;

import com.a100.librarymanagement.exception.BaseException;

public class EmailAlreadyExistsException extends BaseException {
    public EmailAlreadyExistsException(String email) {
        super("Email already exists: " + email);
    }
}