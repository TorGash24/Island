package ru.javarush.entity.herbivores;

import ru.javarush.system.Config;

public class Buffalo extends Herbivore {
    public static int count;

    public Buffalo() {
        super(Config.AnimalType.BUFFALO, 700, 10, 3, 100);
        count++;
    }




}
