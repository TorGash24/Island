package ru.javarush.entity.herbivores;

import ru.javarush.system.Config;

public class Caterpillar extends Herbivore {

    public Caterpillar() {
        // вернуть максимальную сытость на 0
        super(Config.AnimalType.CATERPILLAR, 0.01, 1000, 0, 1);
        count++;
    }


}
