package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Buffalo extends Herbivore {
    public static int count;

    public Buffalo() {
        super(AnimalType.BUFFALO, "buffalo " + count, 700, 10, 3, 100);
        count++;
    }


    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }



}
