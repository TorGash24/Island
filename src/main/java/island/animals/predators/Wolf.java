package island.animals.predators;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Wolf extends Predator {

    public Wolf() {
        super(AnimalType.WOLF, 50, 30, 3, 8);
        count++;
    }

}
