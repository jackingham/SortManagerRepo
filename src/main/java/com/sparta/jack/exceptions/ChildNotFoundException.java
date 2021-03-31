package com.sparta.jack.exceptions;

public class ChildNotFoundException extends Exception {
    public ChildNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}