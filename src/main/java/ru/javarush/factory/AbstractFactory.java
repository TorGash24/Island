package ru.javarush.factory;

import ru.javarush.entity.Animal;
import ru.javarush.system.Config;

public interface AbstractFactory<T extends Animal> {
    T createInstance(Config.AnimalType animalType);

}
