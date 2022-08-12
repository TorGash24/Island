package island.island;

import java.util.Random;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public static Direction getRandomDirection() {
        int random = new Random().nextInt(4);

        switch (random) {
            case 0: return Direction.UP;
            case 1: return Direction.DOWN;
            case 2: return Direction.LEFT;
            case 3: return Direction.RIGHT;
            default: return null;
        }
    }

}
