package com.goit.gojava.group12.project.program;

/**
 * Utility class with methods which implement conversion logic
 * from binary to decimal and vice versa.
 */
public class ConverterUtils {

    /**
     * This method with the logic of conversion input decimal number
     * to String representation of the binary number.
     *
     * @param number int value of the decimal number.
     * @return String representation of the binary number after conversion.
     */
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

    /**
     * This method is the part of toBinary() method.
     * If the input decimal number is a negative this method is being called.
     * Because of the some difference in conversion of positive and negative numbers.
     *
     * @param number int input decimal number.
     * @param result StringBuilder preliminary final result.
     */
    private static void handleNegative(int number, StringBuilder result) {
        inversionOfDigits(number, result);
        additionOfBits(result);
        String finalReturnCode = result.toString();
        result.setLength(0);                         // rebooting our stringBuilder
        addNegativeBits(result, finalReturnCode);
        result.append(finalReturnCode);              // add finalReturnCode bits
    }

    /**
     * this method is for adding last "negative" bit
     * to the binary representation of negative decimal number.
     *
     * @param result StringBuilder preliminary final result.
     * @param finalReturnCode String final result.
     */
    private static void addNegativeBits(StringBuilder result, String finalReturnCode) {
        for (int i = 0; i < Integer.SIZE - finalReturnCode.length(); i++) {
            result.append(1);                        // add negative indicating bits with digit - "1"
        }
    }

    /**
     * This method is for inversion of all binary number's digits.
     * In the case of conversion of negative decimal numbers the digits
     * should be inverted before the addition of the last "negative" bit.
     *
     * @param number int input decimal number.
     * @param result StringBuilder preliminary final result.
     */
    private static void inversionOfDigits(int number, StringBuilder result) {
        while (number < 0) {
            int modulus = (number % 2) == 0 ? 1 : 0;          // inverting all digits of the same positive Integer value
            result.append(modulus);
            number /= 2;
        }
        result.reverse();
    }

    /**
     * This method with the logic of the correct
     * way of addition the bits to binary number's representation.
     *
     * @param result String final result.
     */
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

    /**
     * This method is the part of toBinary() method.
     * If the input decimal number is a positive this method is being called.
     * Because of the some difference in conversion of positive and negative numbers.
     *
     * @param number int input decimal number.
     * @param result StringBuilder preliminary final result.
     */
    private static void handlePositive(int number, StringBuilder result) {
        while (number != 0) {
            result.append(number % 2);
            number /= 2;
        }
        result.reverse();
    }


    /**
     * This method with the logic of conversion input binary number
     * to it's decimal representation.
     *
     * @param binNumber String value of the binary number in String representation.
     * @return String decimal value after conversation in String representation.
     */
    public static String toInteger(String binNumber) {
        StringBuilder buf = new StringBuilder(binNumber).reverse();
        int result = 0;
        for (int i = binNumber.length() - 1; i >= 0; i--) {

            int digit = buf.charAt(i) - '0';
            result += (1 << i) * digit;                                 // involution and summarizing corresponding bits
        }
        return String.valueOf(result);
    }

}


