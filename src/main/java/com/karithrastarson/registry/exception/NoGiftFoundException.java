package com.karithrastarson.registry.exception;

public class NoGiftFoundException extends Exception {
    private String message;
    public NoGiftFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
