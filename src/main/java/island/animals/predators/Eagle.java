package island.animals.predators;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Eagle extends Predator {

    public Eagle() {
        super(AnimalType.EAGLE, "eagle " + count, 6, 20, 3, 1);
        count++;
    }

    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }

}
