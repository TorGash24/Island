package ru.javarush.factory;

import ru.javarush.entity.herbivores.*;
import ru.javarush.system.Config.AnimalType;


public class HerbivoreFactory implements AbstractFactory<Herbivore> {

    @Override
    public Herbivore createInstance(AnimalType animalType) {

        return switch (animalType) {
            case BUFFALO -> new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case DEER -> new Deer();
            case DUCK -> new Duck();
            case GOAT -> new Goat();
            case HOG -> new Hog();
            case HORSE -> new Horse();
            case RABBIT -> new Rabbit();
            case SHEEP -> new Sheep();
            case MOUSE -> new Mouse();
            default -> null;
        };
    }
}
