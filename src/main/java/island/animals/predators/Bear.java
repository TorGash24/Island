package island.animals.predators;

import island.island.AnimalType;

public class Bear extends Predator {
    public static int count;


    public Bear() {
        super(AnimalType.BEAR, "bear " + count, 500, 2, 3, 80);
        count++;
    }





}
