package ru.javarush.entity;

import lombok.Setter;
import ru.javarush.system.Config;
import ru.javarush.system.Config.AnimalType;
import lombok.Getter;
import ru.javarush.island.Coordinate;
import ru.javarush.island.Direction;
import ru.javarush.island.Island;
import ru.javarush.island.Location;

public abstract class Animal {
    @Getter
    private final AnimalType type;

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

    public Animal(AnimalType type, double weight, int maxCountFromLocation, int maxSpeed, double maxSatiety) {
        this.type = type;
        this.weight = weight;
        this.maxCountFromLocation = maxCountFromLocation;
        this.maxSpeed = maxSpeed;
        this.maxSatiety = maxSatiety;
        this.satiety = 0;
    }

    public abstract Animal breed();

    private Coordinate findNextCoordinate(Coordinate currentCoordinate) {
        int randomStep = Config.RandomClass.getRandom(0, maxSpeed);
        Coordinate nextCoordinate = currentCoordinate;

        for (int step = 0; step < randomStep; step++) {
            nextCoordinate = getStep(currentCoordinate);
            currentCoordinate = nextCoordinate;
        }

        return nextCoordinate;
    }

    private Coordinate getStep(Coordinate currentCoordinate) {
        Direction randomDirection = Direction.getRandomDirection();
        Coordinate nextCoordinate = currentCoordinate.selectCoordinate(randomDirection);

        while (!nextCoordinate.isCheckCoordinate()) {
            randomDirection = Direction.getRandomDirection();
            nextCoordinate = currentCoordinate.selectCoordinate(randomDirection);
        }

        return nextCoordinate;
    }

    public void chooseDirection(Location currentLocation, Island island) {
        Coordinate coordinate = findNextCoordinate(currentLocation.getCoordinate());

        island.moveToOtherLocation(coordinate, this);
        currentLocation.leave(this);
    }

    public boolean isSatiety() {
        return this.satiety < this.maxSatiety;
    }

    // TODO
    public boolean checkIsLive() {
        this.satiety = (Math.max(0, satiety - (10 * maxSatiety / 100)));
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
