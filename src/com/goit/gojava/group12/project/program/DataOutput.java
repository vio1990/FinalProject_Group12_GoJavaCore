package com.goit.gojava.group12.project.program;

import com.sun.xml.internal.ws.util.NoCloseInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is utility class for the console output of the messages,
 * which help user to make a choice and some different greeting messages.
 */
public class DataOutput {

    /**
     * This method is for the print in console of a greeting message.
     */
    public static void greeting() {
        System.out.println("Hi, user! I'm very glad you've decided to use our converting program!");
    }

    /**
     * This method is for print the result in console.
     *
     * @param result int result value.
     */
    public static void printResult(String result) {
        System.out.println("Your result is: " + result);
    }

    /**
     * This method is for the print thanks message in console.
     */
    public static void printThanks() {
        System.out.println("Thank you! Good bye!");
    }

    /**
     * This method is for choice an action of user. The user can choose an appropriate
     * action and the application responds to this.
     *
     * @return String the choice of the user.
     * @throws IOException
     */
    public static String asking() throws IOException {
        NoCloseInputStream noCloseStream = new NoCloseInputStream(System.in);
        InputStreamReader inStreamReader = new InputStreamReader(noCloseStream);
        System.out.println("Would you like to launch the converter again?(\"1\" - Yes: \"2\" - No)");
        try (BufferedReader reader = new BufferedReader(inStreamReader)) {
            String result = reader.readLine();
            if (result.equalsIgnoreCase("1") || result.equalsIgnoreCase("2")) {
                return result;
            } else {
                System.out.println("Please, enter \"1\" or \"2\"");
                return DataOutput.asking();
            }
        }
    }
}