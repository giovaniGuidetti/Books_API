package com.bookStore.books_management_api.exception;

public class EntityAlreadyExistsException extends RuntimeException{

    public EntityAlreadyExistsException(String message) {
        super(message);
    }

}
