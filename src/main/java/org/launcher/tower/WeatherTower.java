package org.launcher.tower;

import org.launcher.interfaces.Flyable;
import org.launcher.singleton.WeatherProvider;
import org.launcher.types.Coordinates;

import java.util.List;

public class WeatherTower extends Tower {

    public WeatherTower(List<Flyable> observers) {
        super(observers);
    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getCurrentWeather(coordinates);
    }
}
