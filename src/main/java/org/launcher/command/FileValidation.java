package org.launcher.command;

import org.launcher.exceptions.InvalidFileException;
import org.launcher.exceptions.InvalidPropertiesException;
import org.launcher.interfaces.Flyable;
import org.launcher.singleton.AircraftFactory;
import org.launcher.types.Coordinates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileValidation {
    private final String fileName;

    private BufferedReader file;

    public FileValidation(String fileName) {
        this.fileName = fileName;
        this.file = null;
    }

    public void openFile() {
        try {
            FileReader fileReader = new FileReader(fileName);

            file = new BufferedReader(fileReader);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public void validateFile() {
        try {
            validateProperties();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        try {
            BufferedReader shallowCopy = new BufferedReader(new FileReader(fileName));
            String firstLine = getFirstLine(shallowCopy);

            isFirstLineValid(firstLine);

            shallowCopy.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        // validate name and type of aircraft
        try {
            BufferedReader shallowCopy = new BufferedReader(new FileReader(fileName));

            shallowCopy.readLine();
            String line = shallowCopy.readLine();

            for (int lineNumber = 2; line != null; lineNumber++) {
                validateNameAndType(line, lineNumber);

                line = shallowCopy.readLine();
            }

            shallowCopy.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        try {
            BufferedReader shallowCopy = new BufferedReader(new FileReader(fileName));

            shallowCopy.readLine();
            String line = shallowCopy.readLine();

            for (int lineNumber = 2; line != null; lineNumber++) {
                validateCoordinates(line, lineNumber);

                line = shallowCopy.readLine();
            }

            shallowCopy.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public List<Flyable> getObservers() {
        try {
            file.readLine();

            String line = file.readLine();
            List<Flyable> observers = new ArrayList<>();

            while (line != null) {
                Flyable aircraft = makeFlyable(line);

                observers.add(aircraft);
                line = file.readLine();
            }

            // return file to the beginning
            file.close();
            openFile();


            return observers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public int getNumberOfSimulations() {
        try {
            String firstLine = file.readLine();

            return Integer.parseInt(firstLine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return 0;
    }

    private Flyable makeFlyable(String line) {
        String aircraftType = getAircraftType(line);
        String aircraftName = getAircraftName(line);
        Coordinates aircraftCoordinates = getAircraftCoordinates(line);

        return AircraftFactory.newAircraft(
                aircraftType, aircraftName,
                aircraftCoordinates.getLongitude(),
                aircraftCoordinates.getLatitude(),
                aircraftCoordinates.getHeight()
        );
    }

    private String getAircraftType(String line) {
        String[] aircraftProperties = line.split(" ");

        return aircraftProperties[0];
    }

    private String getAircraftName(String line) {
        String[] aircraftProperties = line.split(" ");

        return aircraftProperties[1];
    }

    private Coordinates getAircraftCoordinates(String line) {
        String[] aircraftProperties = line.split(" ");
        int longitude = Integer.parseInt(aircraftProperties[2]);
        int latitude = Integer.parseInt(aircraftProperties[3]);
        int height = Integer.parseInt(aircraftProperties[4]);

        return new Coordinates(longitude, latitude, height);
    }

    private void validateCoordinates(String line, int lineNumber) throws InvalidPropertiesException {
        String[] aircraftProperties = line.split(" ");

        if (aircraftProperties.length != 5) {
            throw new InvalidPropertiesException("Invalid number of properties: " + aircraftProperties.length + " on line " + lineNumber);
        }

        if (isInvalidCoordinates(aircraftProperties[2])) {
            throw new InvalidPropertiesException("Invalid coordinates: " + aircraftProperties[2] + " on line " + lineNumber);
        }

        if (isInvalidCoordinates(aircraftProperties[3])) {
            throw new InvalidPropertiesException("Invalid coordinates: " + aircraftProperties[3] + " on line " + lineNumber);
        }

        if (isInvalidCoordinates(aircraftProperties[4])) {
            throw new InvalidPropertiesException("Invalid coordinates: " + aircraftProperties[4] + " on line " + lineNumber);
        }
    }

    private boolean isInvalidCoordinates(String aircraftProperty) {
        try {
            Integer.parseInt(aircraftProperty);
        } catch (Exception e) {
            return true;
        }
        return !aircraftProperty.matches("^[0-9]+$");
    }

    private String getFirstLine(BufferedReader file) {
        try {
            return file.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    private void validateNameAndType(String line, int lineNumber) throws Exception {
        String[] aircraftProperties = line.split(" ");

        if (aircraftProperties.length != 5) {
            throw new InvalidPropertiesException("Invalid number of properties: " + aircraftProperties.length + " on line " + lineNumber);
        }

        if (!isValidAircraftType(aircraftProperties[0])) {
            throw new InvalidPropertiesException("Invalid aircraft type: " + aircraftProperties[0] + " on line " + lineNumber);
        }

        if (!isValidAircraftName(aircraftProperties[1])) {
            throw new InvalidPropertiesException("Invalid aircraft name: " + aircraftProperties[1] + " on line " + lineNumber);
        }

    }

    private boolean isFileReadable() {
        try {
            file.mark(1);
            int firstCharacter = file.read();

            file.reset();
            return firstCharacter != -1;
        } catch (Exception e) {
            return false;
        }
    }

    private void validateProperties() throws Exception {
        if (!isFileReadable()) {
            throw new InvalidFileException("File is not readable: " + fileName);
        }
    }

    private void isFirstLineValid(String firstLine) throws Exception {
        if (!firstLine.matches("^[0-9]+$")) {
            throw new InvalidPropertiesException("First line is not a number: " + firstLine);
        }
        if (Integer.parseInt(firstLine) < 0) {
            throw new InvalidPropertiesException("First line is a negative number: " + firstLine);
        }
    }

    private boolean isValidAircraftType(String aircraftType) {
        return aircraftType.equals("Baloon") || aircraftType.equals("Helicopter") || aircraftType.equals("JetPlane");
    }

    private boolean isValidAircraftName(String aircraftName) {
        return aircraftName.matches("^[A-Z][a-z0-9]+$");
    }
}
