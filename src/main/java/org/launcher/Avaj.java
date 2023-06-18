package org.launcher;

import org.launcher.command.FileValidation;
import org.launcher.command.Launcher;

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

        var observersList = fileValidation.getObservers();
        var numberOfSimulations = fileValidation.getNumberOfSimulations();

        Launcher launcher = new Launcher(observersList, numberOfSimulations);
        launcher.run();
    }
}
