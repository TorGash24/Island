package ru.javarush.entity.predators;

import ru.javarush.system.Config;

public class Wolf extends Predator {

    public Wolf() {
        super(Config.AnimalType.WOLF, 50, 30, 3, 8);
        count++;
    }

}
