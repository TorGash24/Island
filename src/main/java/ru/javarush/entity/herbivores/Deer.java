package ru.javarush.entity.herbivores;

import ru.javarush.system.Config.AnimalType;

public class Deer extends Herbivore {

    public Deer() {
        super(AnimalType.DEER, 300, 20, 4, 50);
    }
}
