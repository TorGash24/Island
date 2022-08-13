package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Deer extends Herbivore {

    public Deer() {
        super(AnimalType.DEER, 300, 20, 4, 50);
        count++;
    }


}
