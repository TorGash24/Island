package animals.herbivores;

import island.Location;
import plants.Plant;

public class Duck extends Herbivore{

    public Duck() {
        // вернуть максимальную сытость на 0,15
        super("duck " + count, 1, 200, 4, 1);
        count++;
    }

    @Override
    public void breed() {

    }


    public void chooseDirection() {

    }

    @Override
    public void eat(Location location) {
        super.eat(location);
    }







}
