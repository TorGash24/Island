package ru.javarush.island;

import ru.javarush.entity.Animal;
import ru.javarush.system.Config;
import lombok.Getter;

public class Island {
    public static Island referenceIsland = null;

    @Getter
    private final Island island;

    @Getter
    private final Location[][] locations;

    public Island() {
        locations = new Location[Config.WIDTH][Config.HEIGHT];
        initialize();
        island = this;
        referenceIsland = island;
    }

    public static Island getReferenceIsland() {
        return referenceIsland;
    }


    private void initialize() {
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

    public int getCountPredators() {
        int count = 0;
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                count += locations[x][y].getPredators().size();
            }

        }
        return count;
    }

    public int getCountHerbivores() {
        int count = 0;
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                count += locations[x][y].getHerbivores().size();
            }

        }
        return count;
    }

    public int getCountPlats() {
        int count = 0;
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                count += locations[x][y].getPlants().size();
            }

        }
        return count;
    }

    public int countAnimal() {
        return getCountPredators() + getCountHerbivores();
    }

    public void moveToOtherLocation(Coordinate coordinate, Animal animal) {
        Location location = getLocationByCoordinate(coordinate);
        location.addAnimals(animal);
    }
}