package org.launcher.command;

import org.launcher.interfaces.Flyable;
import org.launcher.tower.WeatherTower;

import java.util.List;

public class Launcher {
    private final WeatherTower weatherTower;

    private final List<Flyable> observers;

    private final int simulations;

    public Launcher(List<Flyable> observers, int simulations) {
        this.observers = observers;
        this.weatherTower = new WeatherTower(observers);
        this.simulations = simulations;
    }

    public void run() {
        // register all the observers to the weather tower
        observers.forEach(flyable -> flyable.registerTower(weatherTower));

        // run the simulation
        for (int i = 0; i < simulations; i++) {
            weatherTower.writeNewSimulation(i + 1);
            weatherTower.conditionsChanged();
            weatherTower.lander();
            weatherTower.writeMessages();
        }
    }



}
