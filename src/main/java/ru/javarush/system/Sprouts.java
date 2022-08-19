package ru.javarush.system;

import ru.javarush.entity.plants.Plant;
import ru.javarush.island.Island;
import ru.javarush.island.Location;

public class Sprouts implements Runnable{

    private final Island island;

    private final Location[][] locations;

    public Sprouts(Island island) {
        this.island = island;
        this.locations = island.getLocations();
    }

    @Override
    public void run() {
        grow();
    }

    public void grow() {
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                Location location = locations[x][y];
                int currentCountPlants = location.getPlants().size();
                int maxCountPlant = Plant.MAX_COUNT_FROM_LOCATION;
                int plantRandomCount = Config.RandomClass.getRandom(0, maxCountPlant);
                if (currentCountPlants + plantRandomCount > maxCountPlant) {
                    plantRandomCount = maxCountPlant - currentCountPlants;
                }
                for (int i = 0; i < plantRandomCount; i++) {
                    location.getPlants().add(new Plant());
                }
            }
        }

    }
}
