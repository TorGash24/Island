package ru.javarush.entity.herbivores;

import ru.javarush.system.Config;

public class Horse extends Herbivore {

    public Horse() {
        super(Config.AnimalType.HORSE, 400, 20 , 4, 60);
        count++;
    }



}
