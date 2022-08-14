package ru.javarush.entity.herbivores;

import ru.javarush.system.Config;

public class Hog extends Herbivore {

    public Hog() {
        super(Config.AnimalType.HOG, 400, 50, 2 , 50);
        count++;
    }




}
