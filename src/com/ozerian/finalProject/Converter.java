package com.ozerian.finalProject;

public class Converter {


    public static String toBinary(int intNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int modulus;
        int returnCodeSize = 0;
        String returnCode;


        if (intNumber > 0) {                                    // for positive Integer numbers
            while (intNumber != 0) {
                modulus = intNumber % 2;
                stringBuilder.append(modulus);
                intNumber = intNumber / 2;
            }
            stringBuilder.reverse();
        } else if (intNumber == 0) {                            // for "0" Integer's value
            stringBuilder.append(0);

        } else {                                                // for negative Integer numbers ("two's complement")
            while (intNumber != 0) {
                modulus = (intNumber % 2) == 0 ? 1 : 0;          // inverting all digits of the same positive Integer value
                stringBuilder.append(modulus);
                intNumber = intNumber / 2;
                returnCode = stringBuilder.toString();
                returnCodeSize = returnCode.length();
            }
            stringBuilder.reverse();                            // reversing the bits

            for (int i = returnCodeSize - 1; i >= 0; i--) {     // Add "1" to the reversed bits
                if (stringBuilder.charAt(i) != '0') {
                    stringBuilder.setCharAt(i, '0');
                } else {
                    stringBuilder.setCharAt(i, '1');
                    break;
                }
            }

            String finalReturnCode = stringBuilder.toString();
            stringBuilder.setLength(0);                         // rebooting our stringBuilder

            for (int i = 0; i < DataInput.MAX_BITS_QUANTITY_FOR_INTEGER - finalReturnCode.length(); i++) {
                stringBuilder.append(1);                        // add negative indicating bits with digit - "1"
            }
            stringBuilder.append(finalReturnCode);              // add finalReturnCode bits
        }

        return stringBuilder.toString();
    }


    public static String toInteger(String binNumber) {
        StringBuilder stringBuilder = new StringBuilder(binNumber).reverse();

        int result = 0;
        for (int i = binNumber.length() - 1; i >= 0; i--) {

            result += (1 << i) * (stringBuilder.charAt(i) == '1' ? 1 : 0); // involuting and summarizing corresponding bits
        }
        return String.valueOf(result);
    }

}


