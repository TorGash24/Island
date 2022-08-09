package animals.herbivores;

import island.Island;
import island.Location;
import plants.Plant;

public class Rabbit extends Herbivore {

    public Rabbit() {
        // вернуть максимальную сытость на 0,45
        super("rabbit " + count, 2, 150, 2, 1);
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
