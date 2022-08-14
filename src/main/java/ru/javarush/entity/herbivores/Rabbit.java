package ru.javarush.entity.herbivores;

import ru.javarush.system.Config.AnimalType;

public class Rabbit extends Herbivore {

    public Rabbit() {
        super(AnimalType.RABBIT, 2, 150, 2, 0.45);
    }
}
