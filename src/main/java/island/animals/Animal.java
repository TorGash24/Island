package island.animals;

import island.island.*;
import lombok.Getter;

import java.util.List;
import java.util.Random;

public abstract class Animal {
    @Getter
    private AnimalType type;

    public static int count;
    public String name; //имя
    public double weight; //вес
    @Getter
    public int maxCountFromLocation; // максимальное количество на клетке
    public int maxSpeed; // максимальная скорость
    public double maxSatiety; // максимальная сытость
    public double satiety; //сытость

    public static double maxWeight;


    public Animal(AnimalType type, String name, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        count++;
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.maxCountFromLocation = maxCountFromLocation;
        this.maxSpeed = maxSpeed;
        this.maxSatiety = maxSatiety;
        this.satiety = new Random().nextInt((int)maxSatiety);
        maxWeight = weight + maxSatiety;
    }


    public boolean isSatiety() {
        return satiety >= maxSatiety;
    }

    public void setParameters(Animal victim) {
        double weightVictim = victim.weight;

        if (weight + weightVictim >= maxWeight) {
            weight = maxWeight;
        } else {
            weight += weightVictim;
        }

        if (satiety + weightVictim >= maxSatiety) {
            satiety = maxSatiety;
        } else {
            satiety += weightVictim;
        }
    }


    public void chooseDirection(Location currentLocation, Island island) {
        Coord coord = findNextCoord(currentLocation.getCoord(), Config.WIDTH, Config.HEIGHT);

        island.moveToOtherLocation(coord, this);
        currentLocation.leave(this);

    }

    private Coord findNextCoord(Coord currentCoord, int max_X, int max_Y) {
        int randomStep = new Random().nextInt(this.maxSpeed+1);
        Coord nextCoord = new Coord(currentCoord.getX(), currentCoord.getY());

        for (int step =0; step < randomStep; step++) {
            nextCoord = getStep(currentCoord, this, Config.WIDTH, Config.HEIGHT);
        }

        return nextCoord;
    }

    private Coord getStep(Coord currentCoord, Animal animal, int x, int y) {
        Direction randomDirection = Direction.getRandomDirection();

        Coord nextCoord = new Coord(currentCoord.getX(), currentCoord.getY());


        nextCoord.moveToDirection(randomDirection);

        while (!nextCoord.isCheckCoord()) {
            nextCoord.setXY(currentCoord.getX(), currentCoord.getY());
            randomDirection = Direction.getRandomDirection();
            nextCoord.moveToDirection(randomDirection);
        }

        return nextCoord;


    }

    public int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }

    public abstract <T extends Animal> void eat(List<T> victim, Location location);


    @Override
    public String toString() {
        return this.getClass().getSimpleName() +"{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", satiety=" + satiety +
                '}';
    }


    public abstract void breed(Location currentLocation);
}


