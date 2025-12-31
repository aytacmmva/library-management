package com.a100.librarymanagement.exception.notfound;

import com.a100.librarymanagement.exception.BaseException;

public class FavoriteBookNotFoundException extends BaseException {
    public FavoriteBookNotFoundException(String message) {
        super(message);
    }
}