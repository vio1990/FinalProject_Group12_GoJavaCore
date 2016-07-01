package com.goit.gojava.group12.project.program;

public class ConverterUtils {


    public static String toBinary(int number) {
        StringBuilder result = new StringBuilder();

        if (number > 0) {                                    // for positive Integer numbers
            handlePositive(number, result);
        } else if (number == 0) {                            // for "0" Integer's value
            result.append(0);
        } else {                                                // for negative Integer numbers ("two's complement")
            handleNegative(number, result);
        }

        return result.toString();
    }

    private static void handleNegative(int number, StringBuilder result) {

        inversionOfDigits(number, result);
        result.reverse();                            // reversing the bits
        additionOfBits(result);

        String finalReturnCode = result.toString();

        result.setLength(0);                         // rebooting our stringBuilder

        addNegativeBits(result, finalReturnCode);
        result.append(finalReturnCode);              // add finalReturnCode bits
    }

    private static void addNegativeBits(StringBuilder result, String finalReturnCode) {
        for (int i = 0; i < Integer.SIZE - finalReturnCode.length(); i++) {
            result.append(1);                        // add negative indicating bits with digit - "1"
        }
    }

    private static void inversionOfDigits(int number, StringBuilder result) {
        while (number < 0) {
            int modulus = (number % 2) == 0 ? 1 : 0;          // inverting all digits of the same positive Integer value
            result.append(modulus);
            number /= 2;
        }
    }

    private static void additionOfBits(StringBuilder result) {
        for (int i = result.length() - 1; i >= 0; i--) {     // Add "1" to the reversed bits
            if (result.charAt(i) == '1') {
                result.setCharAt(i, '0');
            } else {
                result.setCharAt(i, '1');
                break;
            }
        }
    }

    private static void handlePositive(int number, StringBuilder result) {
        while (number != 0) {
            result.append(number % 2);
            number /= 2;
        }
        result.reverse();
    }


    public static String toInteger(String binNumber) {
        StringBuilder buf = new StringBuilder(binNumber).reverse();
        int result = 0;
        for (int i = binNumber.length() - 1; i >= 0; i--) {

            int digit = buf.charAt(i) - '0';
            result += (1 << i) * digit; // involution and summarizing corresponding bits
        }
        return String.valueOf(result);
    }

}


