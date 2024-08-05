package com.example.app.exception;

public class FavouriteAlreadyExistsException extends RuntimeException {
    public FavouriteAlreadyExistsException(String message) {
        super(message);
    }
}