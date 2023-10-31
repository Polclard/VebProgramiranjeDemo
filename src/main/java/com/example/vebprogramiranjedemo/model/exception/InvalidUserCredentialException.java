package com.example.vebprogramiranjedemo.model.exception;

public class InvalidUserCredentialException extends RuntimeException{
    public InvalidUserCredentialException() {
        super("Invalid User Credentials Exception");
    }

    public InvalidUserCredentialException(String message) {
        super(message);
    }

    public InvalidUserCredentialException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserCredentialException(Throwable cause) {
        super(cause);
    }

    public InvalidUserCredentialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
