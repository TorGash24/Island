package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Hog extends Herbivore {

    public Hog() {
        super(AnimalType.HOG, "hog " + count, 400, 50, 2 , 50);
        count++;
    }


    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }

}
