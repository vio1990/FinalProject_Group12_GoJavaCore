package com.goit.gojava.group12.project.program;

import com.goit.gojava.group12.project.exceptions.NoEnteredDataException;
import com.goit.gojava.group12.project.exceptions.WrongDataException;
import com.goit.gojava.group12.project.exceptions.OutOfBitsQuantityException;
import com.sun.xml.internal.ws.util.NoCloseInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataInput {

    public static final String SPECIAL_CASE_1 = "11111111111111111111111111111111";    // more than "Max Integer value"
    public static final String SPECIAL_CASE_2 = "11111111111111111111111111111110";    // more than "Max Integer value"

    public static String enteredChoice() throws IOException {
        NoCloseInputStream noCloseStream = new NoCloseInputStream(System.in);
        InputStreamReader inStreamReader = new InputStreamReader(noCloseStream);
        System.out.println("If you want to convert \"int to binary\", please, enter \"1\"");
        System.out.println("If you want to convert \"binary to int\", please, enter \"2\"");
        System.out.println("If you want to exit, please, enter \"3\"");

        try (BufferedReader reader = new BufferedReader(inStreamReader)) {
            String result = reader.readLine().trim();
            if (result.equalsIgnoreCase("1") || result.equalsIgnoreCase("2") || result.equalsIgnoreCase("3")) {
                return result;
            } else {
                throw new WrongDataException(result);
            }
        } catch (WrongDataException ex) {
            System.out.println("Please, enter \"1\", \"2\" or \"3\"");
            return DataInput.enteredChoice();
        }
    }

    public static int enteredInputDataDecInt() throws IOException {
        NoCloseInputStream noCloseStream = new NoCloseInputStream(System.in);
        InputStreamReader inStreamReader = new InputStreamReader(noCloseStream);
        System.out.println("Please, enter a decimal integer!");
        try (BufferedReader reader = new BufferedReader(inStreamReader)) {
            String inputNumber = reader.readLine().trim();
            if (inputNumber.equalsIgnoreCase("")) {
                throw new NoEnteredDataException();
            }
            int result = Integer.valueOf(inputNumber);
            return result;
        } catch (NoEnteredDataException ex) {
            System.out.println("You've entered nothing! Please enter the decimal integer!");
            return enteredInputDataDecInt();
        } catch (NumberFormatException ex) {
            System.out.println("Input data should be only a decimal integer: ");
            System.out.println("more than " + Integer.MIN_VALUE);
            System.out.println("less than " + Integer.MAX_VALUE);
            return enteredInputDataDecInt();
        }
    }


    public static String enteredInputDataBinary() throws IOException {
        NoCloseInputStream noCloseStream = new NoCloseInputStream(System.in);
        InputStreamReader inStreamReader = new InputStreamReader(noCloseStream);
        System.out.println("Please, enter a binary  number!");
        try (BufferedReader reader = new BufferedReader(inStreamReader)) {
            String result = reader.readLine().trim();
            if (result.length() > Integer.SIZE) {
                throw new OutOfBitsQuantityException(result);
            } else if (result.equalsIgnoreCase(SPECIAL_CASE_1) || result.equalsIgnoreCase(SPECIAL_CASE_2)) {
                throw new OutOfBitsQuantityException(result);
            } else if (result.equalsIgnoreCase("")) {
                throw new NoEnteredDataException();
            }
            char[] binNumbers = result.toCharArray();
            for (char binNumber : binNumbers) {
                if ((binNumber != '1' && binNumber != '0')) {
                    throw new WrongDataException(binNumber);
                }
            }
            return result;
        } catch (NoEnteredDataException ex) {
            System.out.println("You've entered nothing! Please enter the binary number");
            return enteredInputDataBinary();
        } catch (WrongDataException e) {
            System.out.println("Wrong input data! It should include only \"1\" or \"0\", without spaces");
            return enteredInputDataBinary();
        } catch (OutOfBitsQuantityException ex) {
            System.out.println("Out of the maximum bit's value for integer");
            return enteredInputDataBinary();
        }

    }
}