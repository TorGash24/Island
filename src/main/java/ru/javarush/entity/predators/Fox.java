package ru.javarush.entity.predators;

import ru.javarush.system.Config.AnimalType;

public class Fox extends Predator {

    public Fox() {
        super(AnimalType.FOX, 8, 30, 2, 2);
    }
}
