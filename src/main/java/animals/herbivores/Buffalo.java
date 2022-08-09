package animals.herbivores;

import island.Island;
import island.Location;
import plants.Plant;

public class Buffalo extends Herbivore {
    public static int count;

    public Buffalo() {
        super("buffalo " + count, 700, 10, 3, 100);
        count++;
    }

    @Override
    public void breed() {

    }

    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }

    @Override
    public void eat(Location location) {

    }

}
