package ru.javarush.system;

import ru.javarush.island.Island;
import ru.javarush.island.Location;
import lombok.Getter;

public class Game {

    @Getter
    Island island;

    public Game(Island island) {
        this.island = island;
    }

    public void printStatistic() {
        Location[][] locations = island.getLocations();
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                System.out.println("=".repeat(20));
                System.out.println(locations[x][y]);
            }
        }
    }
}