package island.animals.predators;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Snake extends Predator {

    public Snake() {
        super(AnimalType.SNAKE, "snake " + count, 15, 30, 1, 3);
        count++;
    }

    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }


}
