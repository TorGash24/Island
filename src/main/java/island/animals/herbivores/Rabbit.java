package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Rabbit extends Herbivore {

    public Rabbit() {
        // вернуть максимальную сытость на 0,45
        super(AnimalType.RABBIT, "rabbit " + count, 2, 150, 2, 1);
        count++;
    }

    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }


}
