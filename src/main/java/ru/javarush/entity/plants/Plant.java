package ru.javarush.entity.plants;

import ru.javarush.system.Config;
import lombok.Getter;

public class Plant {
    @Getter
    private static Config.AnimalType type = Config.AnimalType.PLANT;

    public static int count;
    @Getter
    public static double weight = 1;
    @Getter
    private static int maxCountFromLocation = 200;

    public Plant() {
        count++;
    }

    @Override
    public String toString() {
        return "Plant{" +
                 '\'' +
                '}';
    }
}
