package org.example.interfaces;

import org.example.tower.WeatherTower;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);
	
}
