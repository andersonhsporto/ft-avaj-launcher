package org.launcher.aircraft;

import org.launcher.interfaces.Flyable;
import org.launcher.singleton.WeatherProvider;
import org.launcher.tower.WeatherTower;
import org.launcher.types.Coordinates;

public class Helicopter extends Aircraft implements Flyable {

    public Helicopter(Long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getCurrentWeather(this.getCoordinates());

        switch (weather) {
            case "RAIN" -> {
                this.getCoordinates().setLongitude(this.getCoordinates().getLongitude() + 5);
                this.setMessage(this.getFlyableName() + ": Damn you rain! You messed up my helicopter.\n");
            }
            case "FOG" -> {
                this.getCoordinates().setLongitude(this.getCoordinates().getLongitude() + 1);
                this.setMessage(this.getFlyableName() + ": Damn you fog! You messed up my helicopter.\n");
            }
            case "SUN" -> {
                this.getCoordinates().setLongitude(this.getCoordinates().getLongitude() + 10);
                this.getCoordinates().setHeight(this.getCoordinates().getHeight() + 2);
                this.setMessage(this.getFlyableName() + ": This is hot.\n");
            }
            case "SNOW" -> {
                this.getCoordinates().setHeight(this.getCoordinates().getHeight() - 12);
                this.setMessage(this.getFlyableName() + ": My rotor is going to freeze!\n");
            }
            default -> {
            }
        }

    }

    @Override
    public String getFlyableName() {
        String sb = "Helicopter#" +
                this.getName() +
                "(" +
                this.getId() +
                ")";

        return sb;
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    @Override
    public Coordinates getFlyableCoordinates() {
        return this.getCoordinates();
    }

    @Override
    public String getFlyableLog() {
        return this.getMessage();
    }

}
