package ru.javarush;

import ru.javarush.system.Game;
import ru.javarush.system.GameWorker;
import ru.javarush.island.Island;

public class Runner {

    public static void main(String[] args) {

        Island island = new Island();
        Game game = new Game(island);
        GameWorker worker = new GameWorker(game);
        worker.start();
    }
}
