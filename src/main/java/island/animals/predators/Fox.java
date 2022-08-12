package island.animals.predators;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Fox extends Predator {

    public Fox() {
        super(AnimalType.FOX, "fox " + count, 8, 30, 2, 2);
        count++;
    }

    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }

}
