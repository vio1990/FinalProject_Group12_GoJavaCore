package com.ozerian.finalProject;

import com.ozerian.finalProject.exceptions.NoEnteredData;
import com.ozerian.finalProject.exceptions.OnlyOneAndZeroValuesException;
import com.ozerian.finalProject.exceptions.OutOfBoundsMaxBitsException;
import com.sun.xml.internal.ws.util.NoCloseInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataInput {

    public static final int MAX_BITS_QUANTITY_FOR_INTEGER = 32;
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
            String inputNumber = reader.readLine().trim();
            if (inputNumber.equalsIgnoreCase("")) {
                throw new NoEnteredData();
            }
            int result = Integer.valueOf(inputNumber);
            return result;
        } catch (NoEnteredData ex) {
            System.out.println("You have entered nothing! Please enter the number!");
            return enteredInputDataInt();
        } catch (NumberFormatException ex) {
            System.out.println("Input data should be only an integer number: ");
            System.out.println("more than " + Integer.MIN_VALUE);
            System.out.println("less than " + Integer.MAX_VALUE);
            return enteredInputDataInt();
        }
    }


    public static String enteredInputDataBinary() throws IOException {
        NoCloseInputStream noCloseStream = new NoCloseInputStream(System.in);
        InputStreamReader inStreamReader = new InputStreamReader(noCloseStream);
        System.out.println("Please, enter a Binary  number!");
        try (BufferedReader reader = new BufferedReader(inStreamReader)) {
            String result = reader.readLine().trim();
            if (result.length() > MAX_BITS_QUANTITY_FOR_INTEGER) {
                throw new OutOfBoundsMaxBitsException(result);
            } else if (result.equalsIgnoreCase(SPECIAL_CASE_1) || result.equalsIgnoreCase(SPECIAL_CASE_2)) {
                throw new OutOfBoundsMaxBitsException(result);
            } else if (result.equalsIgnoreCase("")) {
                throw new NoEnteredData();
            }
            char[] binNumbers = result.toCharArray();
            for (char binNumber : binNumbers) {
                if ((binNumber != '1' && binNumber != '0')) {
                    throw new OnlyOneAndZeroValuesException(binNumber);
                }
            }
            return result;
        } catch (NoEnteredData ex) {
            System.out.println("You have entered nothing!");
            return enteredInputDataBinary();
        } catch (OnlyOneAndZeroValuesException e) {
            System.out.println("Wrong inputData! It should include only \"1\" or \"0\", without spaces");
            return enteredInputDataBinary();
        } catch (OutOfBoundsMaxBitsException ex) {
            System.out.println("Out of the maximum bit's value for Integer number");
            return enteredInputDataBinary();
        }

    }
}