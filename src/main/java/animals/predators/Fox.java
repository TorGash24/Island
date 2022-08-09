package animals.predators;

import animals.herbivores.Herbivore;
import island.Island;
import island.Location;

import java.util.List;

public class Fox extends Predator {

    public Fox() {
        super("fox " + count, 8, 30, 2, 2);
        count++;
    }

    @Override
    public void breed() {

    }

    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }

}
