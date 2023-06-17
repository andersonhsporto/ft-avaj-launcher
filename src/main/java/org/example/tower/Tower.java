package org.example.tower;

import org.example.interfaces.Flyable;

import java.util.List;

public class Tower {
    private final List<Flyable> observers;

    public Tower(List<Flyable> observers) {
        this.observers = observers;
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    public void conditionsChanged() {
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    }
}
