package ru.javarush.entity.herbivores;

import ru.javarush.system.Config;

public class Sheep extends Herbivore {

    public Sheep () {
        super(Config.AnimalType.SHEEP, 70, 140, 3, 15);
        count++;
    }




}
