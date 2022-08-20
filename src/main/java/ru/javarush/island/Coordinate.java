package ru.javarush.island;

import ru.javarush.system.Config;

import java.util.Objects;

public class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate selectCoordinate(Direction direction) {
        return new Coordinate(this.x + direction.getDeltaX(), this.y + direction.getDeltaY());

    }

    public boolean isCheckCoordinate() {
        return (x >= 0 && x < Config.WIDTH) && (y >= 0 && y < Config.HEIGHT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate coordinate = (Coordinate) o;
        return x == coordinate.x && y == coordinate.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}