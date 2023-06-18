package org.launcher.tower;

import org.launcher.interfaces.Flyable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Tower {
    private List<Flyable> observers;

    private final File file;

    public Tower(List<Flyable> observers) {
        this.observers = new CopyOnWriteArrayList<>(observers);
        this.file = new File("simulation.txt");
    }

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
        }

        // write to file
        String message = "Tower says: " + flyable.getFlyableName() + " registered to weather tower.\n";

        writeToFile(message);
        System.out.print(message);
    }

    public void unregister(Flyable flyable) {
        String message = "Tower says: " +
                flyable.getFlyableName() +
                " unregistered from weather tower.\n";

        writeToFile(message);
        observers.remove(flyable);
    }

    public void conditionsChanged() {
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    }

    public void lander() {
        for (Flyable flyable : observers) {
            if (flyable.getFlyableCoordinates().isHeightZero()) {
                unregister(flyable);
            }
        }
    }

    public void writeNewSimulation(int number) {
        writeToFile("Simulation #" + number + "\n");
    }

    public void writeMessages() {
        observers.forEach(flyable -> {
            writeToFile(flyable.getFlyableLog());
        });
    }

    private void writeToFile(String message) {
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));

            fileWriter.append(message);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
