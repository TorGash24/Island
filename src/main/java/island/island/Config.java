package island.island;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Config {

    // Размер игрового поля
    public static final int WIDTH = 4;
    public static final int HEIGHT = 4;

    // Размер локации
    public static final int SIZE_LOCATION = 50;

    // Стартовое количество животных
    public static final int COUNT_PREDATORS = 2;
    public static final int COUNT_HERBIVORES = 2;
    public static final int COUNT_PLANTS = 2;

    // Количество столбцов и строк
    public static final int COLS = 10;
    public static final int ROWS = 8;
    public static final int IMAGE_SIZE = 10;
    public static final List<String> ALL_TYPES_ANIMALS = List.of("buffalo", "caterpillar", "deer", "duck", "goat", "hog", "horse", "mouse", "rabbit", "sheep", "bear", "eagle", "fox", "snake", "wolf");

    public static final Map<String, Map<String, Integer>> PROBABILITIES = Map.of(
            "wolf", Map.of(
                    "horse", 10,
                    "deer", 15,
                    "rabbit", 60,
                    "mouse", 80,
                    "goat", 60,
                    "sheep", 70,
                    "hog", 15,
                    "buffalo", 10,
                    "duck", 40),
            "snake", Map.of(
                    "fox", 15,
                    "rabbit", 20,
                    "mouse", 40,
                    "duck", 10),
            "fox", Map.of(
                    "rabbit", 70,
                    "mouse", 90,
                    "duck", 60,
                    "caterpillar", 40),
            "bear", Map.of(
                    "snake", 80,
                    "horse", 40,
                    "deer", 80,
                    "rabbit", 80,
                    "mouse", 90,
                    "goat", 70,
                    "sheep", 70,
                    "hog", 50,
                    "buffalo", 20,
                    "duck", 10),
            "eagle", Map.of(
                    "fox", 10,
                    "rabbit", 90,
                    "mouse", 90,
                    "duck", 80),
            "hog", Map.of(
                    "mouse", 50
            ),
            "mouse", Map.of(
                    "caterpillar", 90
            ),
            "duck", Map.of(
                    "caterpillar", 90
            ));


    String image = "\uD83D\uDC03";

    public static class RandomClass {

        public static boolean getProbability(int percent) {
            return getRandom(0, 100) < percent;
        }

        public static int getRandom(int from, int to) {
            return ThreadLocalRandom.current().nextInt(from, to + 1);
        }

        public static double getRandom(double from, double to) {
            return ThreadLocalRandom.current().nextDouble(from, to + 1D);
        }

    }

}
