package org.example;

import org.example.command.FileValidation;

public class Avaj {
    public static void main(String[] args) {
        // get the first argument passed to the program
        String scenarioFile = args[0];

        // create a new simulation
        FileValidation fileValidation = new FileValidation(scenarioFile);

        // open the file
        fileValidation.openFile();

        // validate the file
        fileValidation.validateFile();

        System.out.println(fileValidation.getObservers());
    }
}
