package com.ozerian.finalProject.exceptions;

public class OutOfBoundsMaxBitsException extends Exception {
    private String value;

    public OutOfBoundsMaxBitsException(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
