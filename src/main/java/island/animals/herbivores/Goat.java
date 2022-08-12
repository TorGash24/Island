package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Goat extends Herbivore {

    public Goat() {
        super(AnimalType.GOAT, "goat " + count, 60, 140, 3, 10);
        count++;
    }


    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }

}
