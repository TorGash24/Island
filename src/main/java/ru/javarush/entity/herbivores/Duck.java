package ru.javarush.entity.herbivores;

import ru.javarush.system.Config;

public class Duck extends Herbivore{

    public Duck() {
        // вернуть максимальную сытость на 0,15
        super(Config.AnimalType.DUCK, 1, 200, 4, 1);
        count++;
    }


}
