package ru.javarush.system;

import ru.javarush.island.Island;
import ru.javarush.island.Location;

public class Cicle implements Runnable {

    Island island;
    Location location;

    public Cicle(Island island, Location location) {
        this.island = island;
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
