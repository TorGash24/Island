package animals.herbivores;

import island.Island;
import island.Location;
import plants.Plant;

public class Goat extends Herbivore {

    public Goat() {
        super("goat " + count, 60, 140, 3, 10);
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
        super.eat(location);
    }
}
