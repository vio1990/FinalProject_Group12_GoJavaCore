package com.goit.gojava.group12.project;

import com.goit.gojava.group12.project.program.ConverterUtils;
import com.goit.gojava.group12.project.program.DataInput;
import com.goit.gojava.group12.project.program.DataOutput;

import java.io.IOException;

public class ConverterCLI {
    public static void main(String[] args) throws IOException {
        try {
            String continues = null;
            DataOutput.greeting();
            do {

                String choice = DataInput.enteredChoice();

                switch (choice) {
                    case "1":
                        int intNumber = DataInput.enteredInputDataDecInt();
                        String binNumber = ConverterUtils.toBinary(intNumber);
                        DataOutput.printResult(binNumber);
                        continues = DataOutput.asking();
                        break;
                    case "2":
                        String binaryNumber = DataInput.enteredInputDataBinary();
                        String integerNumber = ConverterUtils.toInteger(binaryNumber);
                        DataOutput.printResult(integerNumber);
                        continues = DataOutput.asking();
                        break;
                    case "3":
                        continues = "2";
                        break;
                }
            } while (!continues.equalsIgnoreCase("2"));

            DataOutput.printThanks();

        } catch (IOException ex) {
            System.out.println("Wrong input data!");
        }
    }
}

