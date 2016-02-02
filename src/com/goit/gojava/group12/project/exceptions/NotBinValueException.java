package com.goit.gojava.group12.project.exceptions;

public class NotBinValueException extends Exception {
    private int value;

    public NotBinValueException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
