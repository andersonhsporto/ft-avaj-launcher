package org.launcher;

import org.launcher.command.FileValidation;
import org.launcher.command.Launcher;

public class Avaj {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java -jar avaj_launcher.jar [scenario file]");
            System.exit(1);
        }

        // get the first argument passed to the program
        var scenarioFile = args[0];

        // create a new simulation
        var fileValidation = new FileValidation(scenarioFile);

        // open the file
        fileValidation.openFile();

        // validate the file
        fileValidation.validateFile();

        var observersList = fileValidation.getObservers();
        var numberOfSimulations = fileValidation.getNumberOfSimulations();

        Launcher launcher = new Launcher(observersList, numberOfSimulations);

        System.out.println("Simulation is starting.");

        launcher.run();

        System.out.println("Simulation is over.");
    }
}
