package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Island;
import island.island.Location;

public class Buffalo extends Herbivore {
    public static int count;

    public Buffalo() {
        super(AnimalType.BUFFALO, 700, 10, 3, 100);
        count++;
    }




}
