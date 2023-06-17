package org.example.utils;

public class Coordinates {
    private final int height;
    private final int latitude;
    private final int longitude;

    public Coordinates(int height, int latitude, int longitude) {
        this.height = height;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getHeight() {
        return height;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}
