package ru.javarush.entity.herbivores;

import ru.javarush.system.Config.AnimalType;

public class Hog extends Herbivore {

    public Hog() {
        super(AnimalType.HOG, 400, 50, 2 , 50);
    }
}
