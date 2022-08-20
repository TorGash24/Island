package ru.javarush.system;

import ru.javarush.island.Location;

public class Cycle implements Runnable {

    private final Location location;

    public Cycle(Location location) {
        this.location = location;
    }

    @Override
    public void run() {
        location.getLock().lock();
        try {
            location.calculate();
        } finally {
            location.getLock().unlock();
        }
    }
}
