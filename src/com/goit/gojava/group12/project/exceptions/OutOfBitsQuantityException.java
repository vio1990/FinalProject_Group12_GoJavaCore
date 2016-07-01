package com.goit.gojava.group12.project.exceptions;

/**
 * This exception is for the occasion when user has
 * input number with the size that is bigger than available size.
 */
public class OutOfBitsQuantityException extends Exception {

    private String value;

    /**
     * Constructor for Throwable object.
     *
     * @param value String incorrect input data.
     */
    public OutOfBitsQuantityException(String value) {
        this.value = value;
    }

    /**
     * Get incorrect input data.
     *
     * @return String value.
     */
    public String getValue() {
        return value;
    }
}
