package com.goit.gojava.group12.project.program;

import com.goit.gojava.group12.project.program.ConverterUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterUtilsTest {
    private int integer;
    private String binary;

    @Test
    public void testToBinary() throws Exception {
        integer=-1579;
        String expectedValue = Integer.toBinaryString(integer);
        char[] expectedChars = expectedValue.toCharArray();
        String actualValue = ConverterUtils.toBinary(integer);
        char[] actualChars = actualValue.toCharArray();
        assertArrayEquals(expectedChars, actualChars);
    }


    @Test
    public void testToInteger() throws Exception {
        binary = "011010111010111010111";
        int result = Integer.parseInt(binary, 2);
        String expectedValue = String.valueOf(result);
        char[] expectedChars = expectedValue.toCharArray();
        String actualValue = ConverterUtils.toInteger(binary);
        char[] actualChars = actualValue.toCharArray();
        assertArrayEquals(expectedChars, actualChars);

    }
}