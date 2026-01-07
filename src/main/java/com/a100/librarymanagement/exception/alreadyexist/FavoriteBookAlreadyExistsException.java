package com.a100.librarymanagement.exception.alreadyexist;

import com.a100.librarymanagement.exception.BaseException;

public class FavoriteBookAlreadyExistsException extends BaseException {
    public FavoriteBookAlreadyExistsException(String message) {
        super(message);
    }
}
