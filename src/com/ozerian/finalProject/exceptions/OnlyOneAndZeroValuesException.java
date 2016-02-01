package com.ozerian.finalProject.exceptions;

public class OnlyOneAndZeroValuesException extends Exception {
    private int value;

    public OnlyOneAndZeroValuesException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
