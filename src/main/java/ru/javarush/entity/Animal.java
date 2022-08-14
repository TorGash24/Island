package ru.javarush.entity;

import lombok.Setter;
import ru.javarush.system.Config;
import lombok.Getter;
import ru.javarush.island.Coordinate;
import ru.javarush.island.Direction;
import ru.javarush.island.Island;
import ru.javarush.island.Location;

import java.util.Random;

public abstract class Animal {
    @Getter
    private final Config.AnimalType type;

    public static int count;

    @Getter
    private final double weight;

    @Getter
    public int maxCountFromLocation;

    @Getter
    private final int maxSpeed;

    @Getter
    private final double maxSatiety;

    @Getter
    @Setter
    private double satiety;


    public Animal(Config.AnimalType type, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        count++;
        this.type = type;
        this.weight = weight;
        this.maxCountFromLocation = maxCountFromLocation;
        this.maxSpeed = maxSpeed;
        this.maxSatiety = maxSatiety;
        this.satiety = 0;
    }

    public void setParameters(Animal victim) {
        double weightVictim = victim.weight;

        satiety = Math.min(satiety + weightVictim, maxSatiety);
    }


    public void chooseDirection(Location currentLocation, Island island) {
        Coordinate coordinate = findNextCoord(currentLocation.getCoordinate(), Config.WIDTH, Config.HEIGHT);

        island.moveToOtherLocation(coordinate, this);
        currentLocation.leave(this);

    }

    private Coordinate findNextCoord(Coordinate currentCoordinate, int maxX, int maxY) {
        int randomStep = new Random().nextInt(this.maxSpeed + 1);
        Coordinate nextCoordinate = currentCoordinate;

        for (int step = 0; step < randomStep; step++) {
            nextCoordinate = getStep(currentCoordinate, this, Config.WIDTH, Config.HEIGHT);
        }

        return nextCoordinate;
    }

    private Coordinate getStep(Coordinate currentCoordinate, Animal animal, int x, int y) {
        Direction randomDirection = Direction.getRandomDirection();

        Coordinate nextCoordinate = currentCoordinate.moveToDirection(randomDirection);

        while (!nextCoordinate.isCheckCoordinate()) {
            randomDirection = Direction.getRandomDirection();
            nextCoordinate = currentCoordinate.moveToDirection(randomDirection);
        }

        return nextCoordinate;


    }


    public abstract <T extends Animal> T breed(Location currentLocation);

    public boolean isSatiety() {
        return this.satiety < this.maxSatiety;
    }


    public boolean checkIsLive() {
        this.satiety = (Math.max(0, satiety - (100 * maxSatiety / 100)));
        return satiety > 0;

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                '\'' +
                ", weight=" + weight +
                ", satiety=" + satiety +
                '}';
    }
}


