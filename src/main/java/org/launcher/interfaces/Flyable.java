package org.launcher.interfaces;

import org.launcher.tower.WeatherTower;
import org.launcher.types.Coordinates;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);

    public String getFlyableName();

    public Coordinates getFlyableCoordinates();

    public String getFlyableLog();
}
