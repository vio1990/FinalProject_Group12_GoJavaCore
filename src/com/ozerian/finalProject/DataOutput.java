package com.ozerian.finalProject;

import com.sun.xml.internal.ws.util.NoCloseInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataOutput {

    public static void printResult(String result) {
        System.out.println("Your result is:" + result);
    }

    public static void printThanks() {
        System.out.println("Thank you! Good bye!");
    }

    public static int asking() throws IOException {
        NoCloseInputStream noCloseStream = new NoCloseInputStream(System.in);
        InputStreamReader inStreamReader = new InputStreamReader(noCloseStream);
        System.out.println("Would you like to start program again?(\"1\" - Yes: \"2\" - No)");
        try (BufferedReader reader = new BufferedReader(inStreamReader)) {
            int result = Integer.valueOf(reader.readLine());
            return result;
        }
    }
}
