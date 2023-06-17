package org.example.aircraft;

import org.example.interfaces.Flyable;
import org.example.tower.WeatherTower;
import org.example.utils.Coordinates;
public class JetPlane extends Aircraft implements Flyable {

    public JetPlane(Long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}
