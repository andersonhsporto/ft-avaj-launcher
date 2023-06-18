package org.example.interfaces;

import org.example.tower.WeatherTower;
import org.example.types.Coordinates;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);

    public String getFlyableName();

    public Coordinates getFlyableCoordinates();

    public String getFlyableLog();
}
