package ru.javarush.system;

import ru.javarush.island.Island;
import ru.javarush.island.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread {

    private final Game game;

    public GameWorker(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        startGame();
    }

    private void startGame() {
        System.out.println("\u001B[31m" + "START GAME" + "\u001B[0m");
        Island island = game.getIsland();
        Location[][] locations = island.getLocations();
        ScheduledExecutorService statisticTask = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService gameTask = Executors.newScheduledThreadPool(8);
        ScheduledExecutorService growPlants = Executors.newScheduledThreadPool(1);
        statisticTask.scheduleWithFixedDelay(new Statistic(island), 1000, Config.CYCLE_DURATION, TimeUnit.MILLISECONDS);
        growPlants.scheduleWithFixedDelay(new Sprouts(island), 1000, Config.CYCLE_DURATION, TimeUnit.MILLISECONDS);

        List<Cycle> lifeCycle = new ArrayList<>();
        for (Location[] location : locations) {
            for (Location currentLocation : location) {
                lifeCycle.add(new Cycle(currentLocation));
            }
        }
        for (Cycle cycle : lifeCycle) {
            gameTask.scheduleWithFixedDelay(cycle, Config.CYCLE_DURATION, Config.CYCLE_DURATION, TimeUnit.MILLISECONDS);
        }

        while (true) {
            if (game.getIsland().countAnimal() <= 0) {
                statisticTask.shutdown();
                gameTask.shutdown();
                growPlants.shutdown();
                System.out.println("\u001B[31m" + "END GAME" + "\u001B[0m");
                break;
            }
        }
    }
}