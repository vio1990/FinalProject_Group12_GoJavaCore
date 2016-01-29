package com.ozerian.finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DataOutput {

    public static void printResult(String result) {
        System.out.println("Your result is:" + result);
    }

    public static void printThanks() {
        System.out.println("Thank you! Good bye!");
    }

    public static int asking() throws IOException {
        System.out.println("Would you like to start program again?(\"1\" - Yes: \"2\" - No)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.valueOf(reader.readLine());
        return result;
    }
}
