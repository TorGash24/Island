import animals.predators.Predator;
import island.Config;
import island.Island;
import island.Location;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Island island = Island.getIsland(Config.WIDTH, Config.HEIGHT);
        island.addAnimals();
        island.printStatus();

        Scanner sc = new Scanner(System.in);

        Location[][] locations = island.getLocations();
        while (!sc.nextLine().equals("stop")) {
            for (int x = 0; x < locations.length; x++) {
                for (int y = 0; y < locations[x].length; y++) {
                    Location currentLocation = locations[x][y];
                    currentLocation.calculate();
                }
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("После движения");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            island.printStatus();
        }
    }
}
