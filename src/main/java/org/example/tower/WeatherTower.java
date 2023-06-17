package org.example.tower;

import org.example.interfaces.Flyable;
import org.example.singleton.WeatherProvider;
import org.example.utils.Coordinates;

import java.util.List;

public class WeatherTower extends Tower {

    public WeatherTower(List<Flyable> observers) {
        super(observers);
    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getCurrentWeather(coordinates);
    }
}
