package ru.javarush.entity.predators;

import ru.javarush.system.Config;


public class Snake extends Predator {

    public Snake() {
        super(Config.AnimalType.SNAKE,  15, 30, 1, 3);
        count++;
    }




}
