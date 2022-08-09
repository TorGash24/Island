package animals.predators;

import animals.herbivores.Herbivore;
import island.Island;
import island.Location;

import java.util.List;

public class Snake extends Predator {

    public Snake() {
        super("snake " + count, 15, 30, 1, 3);
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
