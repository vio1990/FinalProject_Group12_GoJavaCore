package com.ozerian.finalProject;

import com.sun.xml.internal.ws.util.NoCloseInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Choice {
    public static void greeting() {
        System.out.println("Hi, user! I'm very glad you decided to use our mini-program!");
    }

    public static String enteredChoice() throws IOException {
        NoCloseInputStream noCloseStream = new NoCloseInputStream(System.in);
        InputStreamReader inStreamReader = new InputStreamReader(noCloseStream);
        System.out.println("If you want to convert \"int to binary\", please, enter \"1\"");
        System.out.println("If you want to convert \"binary to int\", please, enter \"2\"");
        System.out.println("If you want to exit, please, enter \"3\"");

        try (BufferedReader reader = new BufferedReader(inStreamReader)) {
            String result = reader.readLine();
            if (result.equalsIgnoreCase("1") || result.equalsIgnoreCase("2") || result.equalsIgnoreCase("3")) {
                return result;
            } else {
                System.out.println("Please, enter \"1\", \"2\" or \"3\"");
                return Choice.enteredChoice();
            }
        }
    }
}


