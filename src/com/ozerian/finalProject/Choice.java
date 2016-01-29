package com.ozerian.finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Choice {
    public static void greeting() {
        System.out.println("Hi, user! I'm very glad you decided to use our mini-program!");
    }

    public static String enteredChoice() throws IOException {
        System.out.println("If you want to convert \"int to binary\", please, enter \"1\"");
        System.out.println("If you want to convert \"binary to int\", please, enter \"2\"");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = reader.readLine();
        return result;

    }
}


