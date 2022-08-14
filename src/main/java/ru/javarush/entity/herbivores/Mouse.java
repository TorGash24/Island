package ru.javarush.entity.herbivores;

import ru.javarush.system.Config.AnimalType;

public class Mouse extends Herbivore {

    public Mouse() {
        super(AnimalType.MOUSE, 0.05, 500, 1, 0.01);
    }
}
