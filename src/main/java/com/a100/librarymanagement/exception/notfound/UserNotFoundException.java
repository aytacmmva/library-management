package com.a100.librarymanagement.exception.notfound;

import com.a100.librarymanagement.exception.BaseException;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(Integer id) {
        super("User not found with id: " + id);
    }
}