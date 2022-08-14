package ru.javarush.entity.herbivores;

import ru.javarush.system.Config;

public class Deer extends Herbivore {

    public Deer() {
        super(Config.AnimalType.DEER, 300, 20, 4, 50);
        count++;
    }


}
