package org.launcher.aircraft;

import org.launcher.interfaces.Flyable;
import org.launcher.singleton.WeatherProvider;
import org.launcher.tower.WeatherTower;
import org.launcher.types.Coordinates;

public class JetPlane extends Aircraft implements Flyable {

    public JetPlane(Long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getCurrentWeather(this.getCoordinates());

        switch (weather) {
            case "RAIN" -> {
                this.getCoordinates().setLatitude(this.getCoordinates().getLatitude() + 5);
                this.setMessage(this.getFlyableName() + ": It's raining. Better watch out for lightings.\n");
            }
            case "FOG" -> {
                this.getCoordinates().setLatitude(this.getCoordinates().getLatitude() + 1);
                this.setMessage(this.getFlyableName() + ": OMG! Winter is coming!\n");
            }
            case "SUN" -> {
                this.getCoordinates().setLatitude(this.getCoordinates().getLatitude() + 10);
                this.getCoordinates().setHeight(this.getCoordinates().getHeight() + 2);
                this.setMessage(this.getFlyableName() + ": Let's enjoy the good weather and take some pics.\n");
            }
            case "SNOW" -> {
                this.getCoordinates().setHeight(this.getCoordinates().getHeight() - 7);
                this.setMessage(this.getFlyableName() + ": It's snowing. We're gonna crash.\n");
            }
            default -> {
            }
        }

    }

    @Override
    public String getFlyableName() {
        String sb = "JetPlane#" +
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
