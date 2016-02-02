package com.goit.gojava.group12.project.exceptions;

public class OutOfBitsQuantityException extends Exception {
    private String value;

    public OutOfBitsQuantityException(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
