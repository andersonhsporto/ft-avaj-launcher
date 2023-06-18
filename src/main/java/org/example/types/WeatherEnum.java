package org.example.types;

public enum WeatherEnum {
    RAIN(),
    FOG(),
    SUN(),
    SNOW();

    public static String generateWeather(Coordinates coordinates) {
        long timestamp = System.currentTimeMillis();

        return WeatherEnum.values()[
            (int) ((timestamp + coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4)
        ].toString();
    }
}
