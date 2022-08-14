package ru.javarush.system;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Config {

    public static final int WIDTH = 4;
    public static final int HEIGHT = 4;
    public static final int COUNT_DAY = 50;
    public static final long CYCLE_DURATION = 2000;

    public static final Map<AnimalType, Map<AnimalType, Integer>> PROBABILITIES = Map.of(
            AnimalType.WOLF, Map.of(
                    AnimalType.HORSE, 10,
                    AnimalType.DEER, 15,
                    AnimalType.RABBIT, 60,
                    AnimalType.MOUSE, 80,
                    AnimalType.GOAT, 60,
                    AnimalType.SHEEP, 70,
                    AnimalType.HOG, 15,
                    AnimalType.BUFFALO, 10,
                    AnimalType.DUCK, 40),
            AnimalType.SNAKE, Map.of(
                    AnimalType.FOX, 15,
                    AnimalType.RABBIT, 20,
                    AnimalType.MOUSE, 40,
                    AnimalType.DUCK, 10),
            AnimalType.FOX, Map.of(
                    AnimalType.RABBIT, 70,
                    AnimalType.MOUSE, 90,
                    AnimalType.DUCK, 60,
                    AnimalType.CATERPILLAR, 40),
            AnimalType.BEAR, Map.of(
                    AnimalType.SNAKE, 80,
                    AnimalType.HORSE, 40,
                    AnimalType.DEER, 80,
                    AnimalType.RABBIT, 80,
                    AnimalType.MOUSE, 90,
                    AnimalType.GOAT, 70,
                    AnimalType.SHEEP, 70,
                    AnimalType.HOG, 50,
                    AnimalType.BUFFALO, 20,
                    AnimalType.DUCK, 10),
            AnimalType.EAGLE, Map.of(
                    AnimalType.FOX, 10,
                    AnimalType.RABBIT, 90,
                    AnimalType.MOUSE, 90,
                    AnimalType.DUCK, 80),
            AnimalType.HOG, Map.of(
                    AnimalType.MOUSE, 50
            ),
            AnimalType.MOUSE, Map.of(
                    AnimalType.CATERPILLAR, 90
            ),
            AnimalType.DUCK, Map.of(
                    AnimalType.CATERPILLAR, 90
            ));

    public static class RandomClass {

        public static int getRandom(int from, int to) {
            return ThreadLocalRandom.current().nextInt(from, to + 1);
        }

        public static boolean getProbability(int percent) {
            return getRandom(0, 100) < percent;}
    }

    public enum AnimalType {

        BEAR("\uD83D\uDC3B"),
        SNAKE("\uD83D\uDC0D"),
        EAGLE("\uD83E\uDD85"),
        FOX("\uD83E\uDD8A"),
        WOLF("\uD83D\uDC3A"),
        BUFFALO("\uD83D\uDC03"),
        CATERPILLAR("\uD83D\uDC1B"),
        DEER("\uD83E\uDD8C"),
        DUCK("\uD83E\uDD86"),
        GOAT("\uD83D\uDC10"),
        HORSE("\uD83D\uDC0E"),
        MOUSE("\uD83D\uDC01"),
        RABBIT("\uD83D\uDC07"),
        HOG("\uD83D\uDC17"),
        PLANT("\uD83C\uDF3F"),
        SHEEP("\uD83D\uDC11");

        public final String image;

        AnimalType(String image) {
            this.image = image;
        }
    }
}