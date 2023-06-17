package org.example.singleton;

import org.example.aircraft.Baloon;
import org.example.aircraft.Helicopter;
import org.example.aircraft.JetPlane;
import org.example.interfaces.Flyable;
import org.example.utils.Coordinates;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = fixCoordinates(longitude, latitude, height);
        Long id = System.currentTimeMillis();

        switch (type) {
            case "Helicopter":
                return new Helicopter(id, name, coordinates);
            case "JetPlane":
                return new JetPlane(id, name, coordinates);
            case "Baloon":
                return new Baloon(id, name, coordinates);
            default:
                return null;
        }
    }

    private static Coordinates fixCoordinates(int longitude, int latitude, int height) {
        if (longitude < 0) {
            longitude = 0;
        }
        if (latitude < 0) {
            latitude = 0;
        }
        if (height < 0) {
            height = 0;
        }
        if (height > 100) {
            height = 100;
        }
        return new Coordinates(longitude, latitude, height);
    }
}
