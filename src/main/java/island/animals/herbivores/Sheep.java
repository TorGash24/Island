package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Sheep extends Herbivore {

    public Sheep () {
        super(AnimalType.SHEEP, "sheep " + count, 70, 140, 3, 15);
        count++;
    }

    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }


}
