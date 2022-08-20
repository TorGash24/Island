package ru.javarush.system;

import ru.javarush.entity.plants.Plant;
import ru.javarush.island.Island;
import ru.javarush.island.Location;

public class Sprouts implements Runnable {

    private final Location[][] locations;

    public Sprouts(Island island) {
        this.locations = island.getLocations();
    }

    @Override
    public void run() {
        grow();
    }

    public void grow() {
        for (Location[] value : locations) {
            for (Location location : value) {
                int currentCountPlants = location.getPlants().size();
                int maxCountPlant = Plant.MAX_COUNT_FROM_LOCATION;
                int plantRandomCount = Config.RandomClass.getRandom(0, maxCountPlant / 2);
                addPlants(location,
                        Math.min(currentCountPlants + plantRandomCount, maxCountPlant - currentCountPlants));
            }
        }
    }

    private void addPlants(Location location, int countPlants) {
        for (int i = 0; i < countPlants; i++) {
            location.getPlants().add(new Plant());
        }
    }
}
