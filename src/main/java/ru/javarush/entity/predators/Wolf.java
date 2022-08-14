package ru.javarush.entity.predators;

import ru.javarush.system.Config.AnimalType;

public class Wolf extends Predator {

    public Wolf() {
        super(AnimalType.WOLF, 50, 30, 3, 8);
    }
}
