package com.ozerian.finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DataInput {
    public static int enteredInputDataInt() throws IOException {
        System.out.println("Please, enter an Integer number!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.valueOf(reader.readLine());
        return result;
    }


    public static int enteredInputDataBinary() throws IOException {
        System.out.println("Please, enter a Binary  number!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.valueOf(reader.readLine());
        return result;
    }
}