package animals.herbivores;

import island.Island;
import island.Location;
import plants.Plant;

public class Horse extends Herbivore {

    public Horse() {
        super("horse " + count, 400, 20 , 4, 60);
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
