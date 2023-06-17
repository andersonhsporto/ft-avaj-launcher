package org.example.singleton;

import org.example.utils.Coordinates;

public class WeatherProvider {
    private final String[] WEATHER = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static String getCurrentWeather(Coordinates coordinates) {
        return null;
    }
}
