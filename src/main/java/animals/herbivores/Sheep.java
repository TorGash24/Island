package animals.herbivores;

import island.Island;
import island.Location;
import plants.Plant;

public class Sheep extends Herbivore {

    public Sheep () {
        super("sheep " + count, 70, 140, 3, 15);
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
