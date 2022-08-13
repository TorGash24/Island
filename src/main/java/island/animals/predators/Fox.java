package island.animals.predators;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Fox extends Predator {

    public Fox() {
        super(AnimalType.FOX, 8, 30, 2, 2);
        count++;
    }

}
