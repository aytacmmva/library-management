package com.a100.librarymanagement.exception.notfound;

import com.a100.librarymanagement.exception.BaseException;

public class BookNotFoundException extends BaseException {
    public BookNotFoundException(Integer id) {
        super("User not found with id: " + id);
    }
}