package ru.javarush.entity.herbivores;

import ru.javarush.system.Config.AnimalType;

public class Horse extends Herbivore {

    public Horse() {
        super(AnimalType.HORSE, 400, 20 , 4, 60);
    }
}
