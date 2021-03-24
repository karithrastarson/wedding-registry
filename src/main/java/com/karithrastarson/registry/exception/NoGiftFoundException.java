package com.karithrastarson.registry.exception;

public class NoGiftFoundException extends Exception {
    private String name;
    public NoGiftFoundException(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "Gift with name \"" + name + "\" can not be reserved";
    }

}
