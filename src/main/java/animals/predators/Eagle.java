package animals.predators;

import animals.herbivores.Herbivore;
import island.Island;
import island.Location;

import java.util.List;

public class Eagle extends Predator {

    public Eagle() {
        super("eagle " + count, 6, 20, 3, 1);
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
