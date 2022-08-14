package ru.javarush.entity.herbivores;

import ru.javarush.system.Config.AnimalType;

public class Sheep extends Herbivore {

    public Sheep () {
        super(AnimalType.SHEEP, 70, 140, 3, 15);
    }
}