package ru.javarush.entity.plants;

import ru.javarush.system.Config.AnimalType;
import lombok.Getter;

public class Plant {
    @Getter
    private static final AnimalType TYPE = AnimalType.PLANT;

    @Getter
    private static final double WEIGHT = 1;

    @Getter
    private static final int MAX_COUNT_FROM_LOCATION = 200;

    @Override
    public String toString() {
        return "Plant{" +
                 '\'' +
                '}';
    }
}
