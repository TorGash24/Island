package ru.javarush.entity.predators;

import ru.javarush.system.Config.AnimalType;

public class Eagle extends Predator {

    public Eagle() {
        super(AnimalType.EAGLE, 6, 20, 3, 1);
    }
}
