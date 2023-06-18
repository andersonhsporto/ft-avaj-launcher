package org.launcher.aircraft;

import org.launcher.interfaces.Flyable;
import org.launcher.singleton.WeatherProvider;
import org.launcher.tower.WeatherTower;
import org.launcher.types.Coordinates;

public class Baloon extends Aircraft implements Flyable {

    public Baloon(Long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getCurrentWeather(this.getCoordinates());

        switch (weather) {
            case "RAIN" -> {
                this.getCoordinates().setHeight(this.getCoordinates().getHeight() - 5);
                this.setMessage(this.getFlyableName() + ": Damn you rain! You messed up my baloon.\n");
            }
            case "FOG" -> {
                this.getCoordinates().setHeight(this.getCoordinates().getHeight() - 3);
                this.setMessage(this.getFlyableName() + ": Damn you fog! You messed up my baloon.\n");
            }
            case "SUN" -> {
                this.getCoordinates().setLongitude(this.getCoordinates().getLongitude() + 2);
                this.getCoordinates().setHeight(this.getCoordinates().getHeight() + 4);
                this.setMessage(this.getFlyableName() + ": Let's enjoy the good weather and take some pics.\n");
            }
            case "SNOW" -> {
                this.getCoordinates().setHeight(this.getCoordinates().getHeight() - 15);
                this.setMessage(this.getFlyableName() + ": It's snowing. We're gonna crash.\n");
            }
            default -> {
            }
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    @Override
    public String getFlyableName() {
        StringBuilder sb = new StringBuilder();
        sb.append("Baloon#");
        sb.append(this.getName());
        sb.append("(");
        sb.append(this.getId());
        sb.append(")");

        return sb.toString();
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
