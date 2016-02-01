package com.ozerian.finalProject;

import com.ozerian.finalProject.exceptions.OnlyOneZeroException;
import com.sun.xml.internal.ws.util.NoCloseInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataInput {

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
                return DataInput.enteredChoice();
            }
        }
    }

    public static int enteredInputDataInt() throws IOException {
        NoCloseInputStream noCloseStream = new NoCloseInputStream(System.in);
        InputStreamReader inStreamReader = new InputStreamReader(noCloseStream);
        System.out.println("Please, enter an Integer number!");
        try (BufferedReader reader = new BufferedReader(inStreamReader)) {
            int result = Integer.valueOf(reader.readLine());
            return result;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("Input data should be only an integer number and less than " + Integer.MAX_VALUE);
            return enteredInputDataInt();
        }
    }


    public static String enteredInputDataBinary() throws IOException {
        NoCloseInputStream noCloseStream = new NoCloseInputStream(System.in);
        InputStreamReader inStreamReader = new InputStreamReader(noCloseStream);
        System.out.println("Please, enter a Binary  number!");
        try (BufferedReader reader = new BufferedReader(inStreamReader)) {
            String result = reader.readLine();
            char[] binNumbers = result.toCharArray();
            for (char binNumber : binNumbers) {
                if ((binNumber != '1' && binNumber != '0')) {
                    throw new OnlyOneZeroException(binNumber);
                }
            }
            return result;
        } catch (OnlyOneZeroException e) {
            e.printStackTrace();
            System.out.println("Wrong inputData! It should include only \"1\" or \"0\"");
            return enteredInputDataBinary();
        }
    }
}