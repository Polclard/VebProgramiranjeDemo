package com.example.vebprogramiranjedemo.model.exception;

public class PasswordNotMatchingException extends RuntimeException {

    public PasswordNotMatchingException() {
        super("Passwords Do Not Match Exception");
    }
}
