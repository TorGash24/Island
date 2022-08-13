package island.animals;

import island.animals.herbivores.Herbivore;
import island.animals.predators.Predator;
import island.island.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class Animal {
    @Getter
    private AnimalType type;

    public static int count;
    public double weight; //вес
    @Getter
    public int maxCountFromLocation; // максимальное количество на клетке
    public int maxSpeed; // максимальная скорость
    public double maxSatiety; // максимальная сытость
    public double satiety; //сытость

    public static double maxWeight;


    public Animal(AnimalType type, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        count++;
        this.type = type;
        this.weight = weight;
        this.maxCountFromLocation = maxCountFromLocation;
        this.maxSpeed = maxSpeed;
        this.maxSatiety = maxSatiety;
        this.satiety = new Random().nextInt((int) maxSatiety);
        maxWeight = weight + maxSatiety;
    }


    public boolean isSatiety() {
        return satiety >= maxSatiety;
    }

    public void setParameters(Animal victim) {
        double weightVictim = victim.weight;

        satiety = Math.min(satiety + weightVictim, maxSatiety);
    }


    public void chooseDirection(Location currentLocation, Island island) {
        Coord coord = findNextCoord(currentLocation.getCoord(), Config.WIDTH, Config.HEIGHT);

        island.moveToOtherLocation(coord, this);
        currentLocation.leave(this);

    }

    private Coord findNextCoord(Coord currentCoord, int max_X, int max_Y) {
        int randomStep = new Random().nextInt(this.maxSpeed + 1);
        Coord nextCoord = new Coord(currentCoord.getX(), currentCoord.getY());

        for (int step = 0; step < randomStep; step++) {
            nextCoord = getStep(currentCoord, this, Config.WIDTH, Config.HEIGHT);
        }

        return nextCoord;
    }

    private Coord getStep(Coord currentCoord, Animal animal, int x, int y) {
        Direction randomDirection = Direction.getRandomDirection();

        Coord nextCoord = currentCoord.moveToDirection(randomDirection);

        while (!nextCoord.isCheckCoord()) {
            randomDirection = Direction.getRandomDirection();
            nextCoord = currentCoord.moveToDirection(randomDirection);
        }

        return nextCoord;


    }

    public int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                '\'' +
                ", weight=" + weight +
                ", satiety=" + satiety +
                '}';
    }


    public abstract <T> List<T> breed(Location currentLocation);



    public boolean checkIsLive() {
        this.satiety = (Math.max(0, satiety - (10 * maxSatiety / 100)));
        return satiety > 0;

    }
}


