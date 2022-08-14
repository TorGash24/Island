package ru.javarush.system;

import ru.javarush.island.Island;
import ru.javarush.island.Location;

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
        Island island = game.getIsland();
        Location[][] locations = Island.getLocations();
        System.out.println("Start game");
        game.printStatistic();
        int corePoolSize = 1;
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(corePoolSize);
        int day = 1;
        while (day < Config.COUNT_DAY) {
            for (int x = 0; x < locations.length; x++) {
                for (int y = 0; y < locations[x].length; y++) {
                    Location currentLocation = locations[x][y];
                    long duration = Config.CYCLE_DURATION;
                    scheduledExecutorService.scheduleWithFixedDelay(new Cicle(currentLocation), duration, duration, TimeUnit.MILLISECONDS);
                }
            }
            System.out.println("+".repeat(20));
            System.out.println("Day = " + day);
            System.out.println("+".repeat(20));
            day ++;
            game.printStatistic();
        }
        System.out.println("End game");
        scheduledExecutorService.shutdown();
    }
}