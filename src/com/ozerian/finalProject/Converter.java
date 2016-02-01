package com.ozerian.finalProject;

public class Converter {

    public static String toBinary(int intNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int i, b;
        while (intNumber != 0) {
            b = intNumber % 2;
            stringBuilder.append(b);
            intNumber = intNumber / 2;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();

    }

    public static String toInteger(String binNumber) {
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
    }
}


