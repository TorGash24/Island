package ru.javarush.entity.predators;

import ru.javarush.system.Config;

public class Fox extends Predator {

    public Fox() {
        super(Config.AnimalType.FOX, 8, 30, 2, 2);
        count++;
    }

}
