package ru.javarush.entity.predators;

import ru.javarush.system.Config;

public class Eagle extends Predator {

    public Eagle() {
        super(Config.AnimalType.EAGLE, 6, 20, 3, 1);
        count++;
    }


}
