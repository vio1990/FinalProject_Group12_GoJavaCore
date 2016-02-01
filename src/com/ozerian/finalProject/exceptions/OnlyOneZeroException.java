package com.ozerian.finalProject.exceptions;

public class OnlyOneZeroException extends Exception {
    private int value;

    public OnlyOneZeroException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
