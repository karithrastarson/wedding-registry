package com.karithrastarson.registry.exception;

public class NoGiftFoundException extends Exception {
    private String phrase;
    public NoGiftFoundException(String phrase) {
        super(phrase);
        this.phrase = phrase;
    }

    @Override
    public String getMessage() {
        return "No fact found for phrase \"" + phrase + "\"";
    }

}
