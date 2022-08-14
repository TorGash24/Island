package ru.javarush.island;

import ru.javarush.entity.Animal;
import ru.javarush.system.Config;
import lombok.Getter;

public class Island {

    private static Island island;

    @Getter
    private static Location[][] locations;

    public static Island getIsland() {
        if (island == null) {
            island = new Island();
            locations = new Location[Config.WIDTH][Config.HEIGHT];
            initialize();
            return island;
        }
        return island;
    }

    private static void initialize() {
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                locations[x][y] = new Location(new Coordinate(x, y));
            }
        }
    }

    private Location getLocationByCoordinate(Coordinate coordinate) {
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

    public void moveToOtherLocation(Coordinate coordinate, Animal animal) {
        Location location = getLocationByCoordinate(coordinate);
        location.addAnimals(animal);
    }
}