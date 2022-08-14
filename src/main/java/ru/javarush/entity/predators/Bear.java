package ru.javarush.entity.predators;

import ru.javarush.system.Config.AnimalType;

public class Bear extends Predator {

    public Bear() {
        super(AnimalType.BEAR, 500, 2, 3, 80);
    }
}
