package animals.predators;

import animals.herbivores.Herbivore;

import java.util.List;

public class Bear extends Predator {

    final double WEIGHT = 500;
    final double possibleDistance = 2;
    final double maxSatiety = 80;
    private double satiety;

    public double getSatiety() {
        return satiety;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }


    @Override
    public void breed() {

    }

    @Override
    public void chooseDirection() {

    }

    @Override
    public void eat(List<Herbivore> herbivores) {

    }
}
