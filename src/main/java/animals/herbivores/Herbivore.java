package animals.herbivores;

import animals.Animal;
import island.Location;
import plants.Plant;

public abstract class Herbivore extends Animal {
    public static int count;

    public Herbivore(String name, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        super(name, weight, maxCountFromLocation, maxSpeed, maxSatiety);
        count++;
    }

    @Override
    public void eat(Location location) {

    }
}
