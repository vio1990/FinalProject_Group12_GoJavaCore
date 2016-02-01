package com.ozerian.finalProject;

public class Converter {

    public static final int MAX_BIT_SIZE = 32;

    public static String toBinary(int intNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int modulo = 0;
        String returnCode = null;

        if (intNumber > 0) {
            while (intNumber != 0) {
                modulo = intNumber % 2;
                stringBuilder.append(modulo);
                intNumber = intNumber / 2;
            }

        } else if (intNumber == 0) {
            stringBuilder.append(0);

        } else {                                        // two's complement
            while (intNumber != 0) {
                modulo = (intNumber % 2) == 0 ? 1 : 0;  // change a bit the opposite
                stringBuilder.append(modulo);
                intNumber = intNumber / 2;
                returnCode = stringBuilder.toString();
            }
            for (int i = 0; i < MAX_BIT_SIZE - returnCode.length(); i++) {
                stringBuilder.append(1);                // change other bits with "0" value on the opposite value - "1"
            }
            stringBuilder.replace(0, 1, "1"); // add "1" to the returnCode
        }

        stringBuilder.reverse();
        return stringBuilder.toString();
    }


    /*public static String toInteger(String binNumber) {
        StringBuilder stringBuilder = new StringBuilder(binNumber);
        stringBuilder.reverse();
        char[] numbers = stringBuilder.toString().toCharArray();
        int[] num = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i] = Character.getNumericValue(numbers[i]);
            num[i] = (int) (Math.pow(2, i) * num[i]);
        }
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            result = result + num[i];
        }
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder.append(result);
        return stringBuilder.toString();
    }*/

    public static String toInteger(String binaryNumber){
        String reverseBinaryNumber = new StringBuilder(binaryNumber).reverse().toString();
        int result = 0;
        for(int i = binaryNumber.length() - 1; i >= 0 ; i--){

            result += (1 << i ) * (reverseBinaryNumber.charAt(i) == '1' ? 1 : 0);
        }
        return String.valueOf(result);
    }

}


