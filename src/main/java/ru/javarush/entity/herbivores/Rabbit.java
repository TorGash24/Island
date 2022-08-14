package ru.javarush.entity.herbivores;

import ru.javarush.system.Config;

public class Rabbit extends Herbivore {

    public Rabbit() {
        // вернуть максимальную сытость на 0,45
        super(Config.AnimalType.RABBIT, 2, 150, 2, 1);
        count++;
    }




}
