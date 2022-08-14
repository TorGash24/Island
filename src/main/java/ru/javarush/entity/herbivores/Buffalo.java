package ru.javarush.entity.herbivores;

import ru.javarush.system.Config.AnimalType;

public class Buffalo extends Herbivore {

    public Buffalo() {
        super(AnimalType.BUFFALO, 700, 10, 3, 100);
    }
}