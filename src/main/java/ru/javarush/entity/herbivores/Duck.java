package ru.javarush.entity.herbivores;

import ru.javarush.system.Config.AnimalType;

public class Duck extends Herbivore{

    public Duck() {
        super(AnimalType.DUCK, 1, 200, 4, 0.15);
    }
}
