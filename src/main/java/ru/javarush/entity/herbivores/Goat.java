package ru.javarush.entity.herbivores;

import ru.javarush.system.Config;

public class Goat extends Herbivore {

    public Goat() {
        super(Config.AnimalType.GOAT, 60, 140, 3, 10);
        count++;
    }


}
