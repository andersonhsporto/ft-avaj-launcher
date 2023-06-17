package org.example.aircraft;

import org.example.utils.Coordinates;

public class Aircraft {
    private Long id;
    private String name;
    private Coordinates coordinates;

    public Aircraft(Long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }
}
