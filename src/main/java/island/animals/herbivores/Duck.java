package island.animals.herbivores;

import island.island.AnimalType;
import island.island.Location;

public class Duck extends Herbivore{

    public Duck() {
        // вернуть максимальную сытость на 0,15
        super(AnimalType.DUCK, "duck " + count, 1, 200, 4, 1);
        count++;
    }



    public void chooseDirection() {

    }

}
