package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Caterpillar extends Herbivore {

    public Caterpillar() {
        // вернуть максимальную сытость на 0
        super(AnimalType.CATERPILLAR, "caterpillar " + count, 0.01, 1000, 0, 1);
        count++;
    }

    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }

}
