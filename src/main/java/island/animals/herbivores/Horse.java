package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Horse extends Herbivore {

    public Horse() {
        super(AnimalType.HORSE, "horse " + count, 400, 20 , 4, 60);
        count++;
    }


    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }

}
