package com.sparta.jack.exceptions;

public class ArrayTooSmallException extends Exception {
    public ArrayTooSmallException(String errorMessage) {
        super(errorMessage);
    }
}