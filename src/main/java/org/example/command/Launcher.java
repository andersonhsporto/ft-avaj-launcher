package org.example.command;

import org.example.interfaces.Flyable;
import org.example.tower.WeatherTower;

import java.util.List;

public class Launcher {
    private final WeatherTower weatherTower;

    private final List<Flyable> observers;

    public Launcher(List<Flyable> observers) {
        this.observers = observers;
        this.weatherTower = null;
    }
}
