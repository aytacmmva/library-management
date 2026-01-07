package com.a100.librarymanagement.exception.alreadyexist;

import com.a100.librarymanagement.exception.BaseException;

public class UserAlreadyExistsException extends BaseException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
