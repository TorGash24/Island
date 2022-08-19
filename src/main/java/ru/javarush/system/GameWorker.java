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
        Island island = game.getIsland();
        Location[][] locations = island.getLocations();
        ScheduledExecutorService statisticTask = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService gameTask = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService growPlants = Executors.newScheduledThreadPool(1);
        statisticTask.scheduleWithFixedDelay(new Statistic(island), 1000, 2000, TimeUnit.MILLISECONDS);
        growPlants.scheduleWithFixedDelay(new Sprouts(island), 1000, 2000, TimeUnit.MILLISECONDS);

        List<Cicle> cicleTasks = new ArrayList<>();
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                Location currentLocation = locations[x][y];
                cicleTasks.add(new Cicle(currentLocation));
            }
        }
        for (Cicle cicle : cicleTasks) {
            gameTask.scheduleWithFixedDelay(cicle, 2000, 2000, TimeUnit.MILLISECONDS);
        }
    }

//    private void startGame() {
//        Island island = game.getIsland();
//        Location[][] locations = island.getLocations();
//        System.out.println("Start game");
//        game.printStatistic();
//        int corePoolSize = 1;
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(corePoolSize);
//        int day = 1;
//        while (day < Config.COUNT_DAY) {
//            for (int x = 0; x < locations.length; x++) {
//                for (int y = 0; y < locations[x].length; y++) {
//                    Location currentLocation = locations[x][y];
//                    long duration = Config.CYCLE_DURATION;
//                    scheduledExecutorService.scheduleWithFixedDelay(new Cicle(currentLocation), duration, duration, TimeUnit.MILLISECONDS);
//                }
//            }
//            System.out.println("+".repeat(20));
//            System.out.println("Day = " + day);
//            System.out.println("+".repeat(20));
//            day ++;
//            game.printStatistic();
//        }
//        System.out.println("End game");
//        scheduledExecutorService.shutdown();
//    }
}