package com.ozerian.finalProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int continues;
            Choice.greeting();
            do {
                String choice = Choice.enteredChoice();

                switch (choice) {
                    case "1":
                        int number = DataInput.enteredInputDataInt();
                        String binaryNumber = Converter.binaryNumber(number);
                        DataOutput.printResult(binaryNumber);
                        DataOutput.printThanks();
                }
                continues = DataOutput.asking();
            } while (continues != 2);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
