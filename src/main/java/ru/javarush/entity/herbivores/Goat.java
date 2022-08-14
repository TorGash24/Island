package ru.javarush.entity.herbivores;

import ru.javarush.system.Config.AnimalType;

public class Goat extends Herbivore {

    public Goat() {
        super(AnimalType.GOAT, 60, 140, 3, 10);
    }
}
