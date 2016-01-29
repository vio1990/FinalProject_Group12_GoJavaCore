package com.ozerian.finalProject;

public class Converter {

    public static String binaryNumber(int a) {
        StringBuilder stringBuilder = new StringBuilder();
        int i, b;
        while (a != 0) {
            b = a % 2;
            stringBuilder.append(b);
            a = a / 2;
        }
        stringBuilder.reverse();
        String result = stringBuilder.toString();
        return result;
    }
}
