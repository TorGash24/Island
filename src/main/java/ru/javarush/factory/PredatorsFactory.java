package ru.javarush.factory;

import ru.javarush.entity.predators.*;
import ru.javarush.system.Config;

public class PredatorsFactory implements AbstractFactory<Predator> {

    @Override
    public Predator createInstance(Config.AnimalType animalType) {
        return switch (animalType) {
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case FOX -> new Fox();
            case SNAKE -> new Snake();
            case WOLF -> new Wolf();
            default -> null;
        };
    }
}
