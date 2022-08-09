package animals.predators;

import animals.herbivores.Herbivore;
import island.Island;
import island.Location;

import java.util.List;

public class Wolf extends Predator {

    public Wolf() {
        super("wolf " + count, 50, 30, 3, 8);
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
