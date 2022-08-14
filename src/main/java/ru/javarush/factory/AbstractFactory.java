package ru.javarush.factory;

import ru.javarush.entity.Animal;
import ru.javarush.system.Config.AnimalType;

public interface AbstractFactory<T extends Animal> {
    T createInstance(AnimalType animalType);
}
