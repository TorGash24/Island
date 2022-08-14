package ru.javarush.entity.herbivores;

import ru.javarush.system.Config;

public class Mouse extends Herbivore {

    public Mouse() {
        // вернуть максимальную сытость на 0,01
        super(Config.AnimalType.MOUSE, 0.05, 500, 1, 1);
        count++;
    }


}
