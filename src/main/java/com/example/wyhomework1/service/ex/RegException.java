package com.example.wyhomework1.service.ex;

public class RegException extends ServiceException{
    public RegException() {
        super();
    }

    public RegException(String message) {
        super(message);
    }

    public RegException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegException(Throwable cause) {
        super(cause);
    }

    protected RegException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
