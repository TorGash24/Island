package ru.javarush.entity.herbivores;

import ru.javarush.system.Config.AnimalType;

public class Caterpillar extends Herbivore {

    public Caterpillar() {
        super(AnimalType.CATERPILLAR, 0.01, 1000, 0, 0);
    }
}