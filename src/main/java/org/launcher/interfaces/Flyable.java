package org.launcher.interfaces;

import org.launcher.tower.WeatherTower;
import org.launcher.types.Coordinates;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower weatherTower);

    String getFlyableName();

    Coordinates getFlyableCoordinates();

    String getFlyableLog();
}
