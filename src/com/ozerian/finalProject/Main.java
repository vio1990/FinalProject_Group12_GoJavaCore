package com.ozerian.finalProject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            int continues = 0;
            Choice.greeting();
            do {
                String choice = Choice.enteredChoice();

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
                        continues = 2;
                        break;
                }
            } while (continues != 2);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
