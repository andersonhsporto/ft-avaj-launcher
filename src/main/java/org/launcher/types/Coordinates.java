package org.launcher.types;

public class Coordinates {
    private int height;
    private int latitude;
    private int longitude;

    public Coordinates(int height, int latitude, int longitude) {
        this.height = height;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public boolean isHeightZero() {
        return this.height == 0;
    }


    @Override
    public String toString() {
        return "Coordinates { " +
                "height = " + height +
                ", latitude =" + latitude +
                ", longitude =" + longitude +
                '}';
    }
}
