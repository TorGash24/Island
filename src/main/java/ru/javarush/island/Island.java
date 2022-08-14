package ru.javarush.island;

import ru.javarush.entity.Animal;
import ru.javarush.system.Config;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class Island {

    @Getter
    private static Island island;

    @Getter
    private static Location[][] locations;

    public static Island getIsland() {
        island = new Island();
        locations = new Location[Config.WIDTH][Config.HEIGHT];
        island.initialize();
        return island;
    }

    private void initialize() {
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                locations[x][y] = new Location(new Coordinate(x, y));
            }
        }
    }

    public void printStatus() {

        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                System.out.println(locations[x][y]);
            }
        }
    }

    public void moveToOtherLocation(Coordinate coordinate, Animal animal) {
        Location location = getLocationByCoord(coordinate);
        location.addAnimals(animal);
    }

    private Location getLocationByCoord(Coordinate coordinate) {
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                Location location = locations[x][y];
                if (location.getCoordinate().equals(coordinate)) {
                    return location;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}