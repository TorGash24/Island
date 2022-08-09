package plants;

import animals.Animal;
import island.Island;
import island.Location;

public abstract class Plant extends Animal {

    public Plant(String name, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        super(name, weight, maxCountFromLocation, maxSpeed, maxSatiety);
    }

    @Override
    public void breed() {

    }

    @Override
    public boolean isSatiety() {
        return super.isSatiety();
    }

    @Override
    public void chooseDirection(Location currentLocation, Island island) {
        super.chooseDirection(currentLocation, island);
    }

    @Override
    public int getRandomNumber(int bound) {
        return super.getRandomNumber(bound);
    }

    @Override
    public void eat(Location location) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
