package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Mouse extends Herbivore {

    public Mouse() {
        // вернуть максимальную сытость на 0,01
        super(AnimalType.MOUSE, "mouse " + count, 0.05, 500, 1, 1);
        count++;
    }

    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }

}
