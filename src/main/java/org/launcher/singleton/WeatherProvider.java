package org.launcher.singleton;

import org.launcher.types.Coordinates;
import org.launcher.types.WeatherEnum;

public class WeatherProvider {
    private WeatherProvider() {
    }

    public static String getCurrentWeather(Coordinates coordinates) {
        return WeatherEnum.generateWeather(coordinates);
    }
}
