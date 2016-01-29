package com.ozerian.finalProject;

import com.sun.xml.internal.ws.util.NoCloseInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataInput {
    public static int enteredInputDataInt() throws IOException {
        System.out.println("Please, enter an Integer number!");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new NoCloseInputStream(System.in)))) {
            int result = Integer.valueOf(reader.readLine());
            return result;
        }
    }


    public static int enteredInputDataBinary() throws IOException {
        System.out.println("Please, enter a Binary  number!");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new NoCloseInputStream(System.in)))) {
            int result = Integer.valueOf(reader.readLine());
            return result;
        }
    }
}