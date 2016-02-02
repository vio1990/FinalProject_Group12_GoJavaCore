package com.ozerian.finalProject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            String continues = null;
            DataOutput.greeting();
            do {

                String choice = DataInput.enteredChoice();

                switch (choice) {
                    case "1":
                        int intNumber = DataInput.enteredInputDataInt();
                        String binNumber = Converter.toBinary(intNumber);
                        DataOutput.printResult(binNumber);
                        DataOutput.printThanks();
                        continues = DataOutput.asking();
                        break;
                    case "2":
                        String binaryNumber = DataInput.enteredInputDataBinary();
                        String integerNumber = Converter.toInteger(binaryNumber);
                        DataOutput.printResult(integerNumber);
                        DataOutput.printThanks();
                        continues = DataOutput.asking();
                        break;
                    case "3":
                        DataOutput.printThanks();
                        continues = "2";
                        System.out.println(Converter.toBinary(-44));
                        break;
                }
            } while (!continues.equalsIgnoreCase("2"));

        } catch (IOException ex) {
            System.out.println("Wrong input data!");
        }
    }
}

