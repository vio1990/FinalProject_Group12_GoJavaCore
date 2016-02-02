package com.goit.gojava.group12.project.exceptions;

public class WrongDataException extends Exception {
    private int inputValue;
    private String dataInput;

    public WrongDataException(int inputValue) {
        this.inputValue = inputValue;
    }

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
