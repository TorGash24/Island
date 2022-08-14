package ru.javarush.entity.predators;

import ru.javarush.system.Config;

public class Bear extends Predator {
    public static int count;


    public Bear() {
        super(Config.AnimalType.BEAR, 500, 2, 3, 80);
        count++;
    }





}
