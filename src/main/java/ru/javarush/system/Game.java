package ru.javarush.system;

import ru.javarush.island.Island;
import lombok.Getter;

public class Game {

    @Getter
    Island island;

    public Game(Island island) {
        this.island = island;
    }
}