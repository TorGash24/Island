package ru.javarush.entity.predators;

import ru.javarush.system.Config.AnimalType;

public class Snake extends Predator {

    public Snake() {
        super(AnimalType.SNAKE,  15, 30, 1, 3);
    }
}
