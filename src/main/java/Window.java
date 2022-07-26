import animals.herbivores.Duck;
import animals.predators.Bear;
import island.Config;
import island.Island;
import island.Location;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class Window implements Runnable {

    JFrame frame;
    Location[][] locations;
    Island island;


    @Override
    public void run() {
        initFrame();
        initIsland();
        initAnimals();

    }

    private void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.WIDTH, Config.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Island");
    }

    private void initIsland() {
        island = new Island();
        island.initialize();
    }

    private void initAnimals() {
        locations = island.getLocations();

        for (int i = 0; i < Config.COUNT_HERBIVORES; i++) {
            int x = new Random().nextInt(Config.WIDTH);
            int y = new Random().nextInt(Config.HEIGHT);
            locations[x][y].addPredatorToLocation(new Bear());
            locations[x][y].addHerbivoreToLocation(new Duck());
        }

        for (int i = 0; i < Config.COUNT_PREDATORS; i++) {
            int x = new Random().nextInt(Config.WIDTH);
            int y = new Random().nextInt(Config.HEIGHT);
            locations[x][y].addPredatorToLocation(new Bear());
            locations[x][y].addHerbivoreToLocation(new Duck());
        }

        for (int i = 0; i < Config.COUNT_PLANTS; i++) {
            int x = new Random().nextInt(Config.WIDTH);
            int y = new Random().nextInt(Config.HEIGHT);
            locations[x][y].addPredatorToLocation(new Bear());
            locations[x][y].addHerbivoreToLocation(new Duck());
        }
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                locations[x][y].printAnimals();

            }
        }


    }
}
