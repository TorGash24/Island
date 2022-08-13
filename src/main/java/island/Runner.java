package island;

import island.island.Config;
import island.island.Island;
import island.island.Location;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Runner {

    public static void main(String[] args) {

        Island island = Island.getIsland(Config.WIDTH, Config.HEIGHT);
        island.addAnimals();
        System.out.println("Start position");
        island.printStatus();
        ExecutorService service = Executors.newScheduledThreadPool(1);
        Location[][] locations = island.getLocations();

        int count = 1;

        while (count < 10) {
            for (int x = 0; x < locations.length; x++) {
                for (int y = 0; y < locations[x].length; y++) {
                    Location currentLocation = locations[x][y];
                    service.submit(new Cicle(island, currentLocation));
                }
            }
            System.out.println("+++++++++++++++++++++++++++");
            System.out.println("Step number " + count);
            System.out.println("+++++++++++++++++++++++++++");
            island.printStatus();
        count++;
        }
        service.shutdown();



//        Island island = Island.getIsland(Config.WIDTH, Config.HEIGHT);
////        island.addAnimals();
//        island.printStatus();
//
//        Scanner sc = new Scanner(System.in);
//
//        Location[][] locations = island.getLocations();
//        while (!sc.nextLine().equals("stop")) {
//            for (int x = 0; x < locations.length; x++) {
//                for (int y = 0; y < locations[x].length; y++) {
//                    Location currentLocation = locations[x][y];
//                    currentLocation.calculate();
//                }
//            }
//            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            System.out.println("После движения");
//            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            island.printStatus();
//        }
    }
}
