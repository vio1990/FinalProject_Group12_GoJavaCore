package com.goit.gojava.group12.project.exceptions;

/**
 * This exception is for handling occasions when the user has
 * input the data which cannot be to process.
 */
public class WrongDataException extends Exception {

    private int inputValue;

    private String dataInput;

    /***
     * Constructor of the Throwable object.
     *
     * @param inputValue int the value of the input data.
     */
    public WrongDataException(int inputValue) {
        this.inputValue = inputValue;
    }

    /***
     * Constructor of the Throwable object.
     *
     * @param dataInput String value of the input data in String representation.
     */
    public WrongDataException(String dataInput) {
        this.dataInput = dataInput;
    }

    public int getInputValue() {
        return inputValue;
    }

    public String getDataInput() {
        return dataInput;
    }
}
