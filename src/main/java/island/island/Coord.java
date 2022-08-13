package island.island;

import java.util.Objects;


public class Coord {

    Direction direction;

    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coord moveToDirection(Direction direction) {
        return new Coord(this.x + direction.getDeltaX(), this.y + direction.getDeltaY());

    }

    public boolean isCheckCoord() {
        return (x >= 0 && x < Config.WIDTH) && (y >= 0 && y < Config.HEIGHT);
    }


    public Coord moveUp() {
        y--;
        return this;
    }


    public Coord moveDown() {
        y++;
        return this;
    }


    public Coord moveLeft() {
        x--;
        return this;
    }


    public Coord moveRight() {
        x++;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x && y == coord.y;
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
