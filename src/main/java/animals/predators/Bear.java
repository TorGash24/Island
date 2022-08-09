package animals.predators;

import animals.herbivores.Herbivore;
import island.Location;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Predator {
    public static int count;

    public Bear() {
        super("bear " + count, 500, 2, 3, 80);
        count++;
    }

    @Override
    public void breed() {

    }




}
