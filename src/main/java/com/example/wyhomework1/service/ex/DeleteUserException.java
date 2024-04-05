package com.example.wyhomework1.service.ex;

public class DeleteUserException extends ServiceException{
    public DeleteUserException() {
        super();
    }

    public DeleteUserException(String message) {
        super(message);
    }

    public DeleteUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteUserException(Throwable cause) {
        super(cause);
    }

    protected DeleteUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
